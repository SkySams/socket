package com.service.app.service.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.service.app.initializer.ServerChannelInitializar;

@Component
public class NettyService {

	protected Logger logger = LoggerFactory.getLogger(NettyService.class);

	public void start(InetSocketAddress inetSocketAddress) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap()
					.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.localAddress(inetSocketAddress)
					.childHandler(new ServerChannelInitializar())
					.option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture channelFuturn = serverBootstrap.bind(
					inetSocketAddress).sync();
			logger.info("servet start listent at", inetSocketAddress.getAddress());
			channelFuturn.channel().closeFuture().sync();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

}
