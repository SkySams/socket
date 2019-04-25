package com.service.app.initializer;

import com.service.app.handler.ServerHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.internal.ChannelUtils;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ServerChannelInitializar extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		// TODO Auto-generated method stub
		socketChannel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast(new ServerHandler());
	}

}
