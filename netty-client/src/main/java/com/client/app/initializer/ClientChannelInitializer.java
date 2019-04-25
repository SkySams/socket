package com.client.app.initializer;

import com.client.app.handler.ChannelHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline p = socketChannel.pipeline();
        p.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        p.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        p.addLast(new ChannelHandler());
	}

}
