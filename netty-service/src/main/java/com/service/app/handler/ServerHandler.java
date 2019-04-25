package com.service.app.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


public class ServerHandler extends ChannelInboundHandlerAdapter {

	 private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channelActive----->");
        System.out.println(ctx.channel().id()+" come into the chattingroom,"+"Online: "+channels.size());
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead......");
        System.out.println(ctx.channel().remoteAddress()+"----->Server :"+ msg.toString());
        System.out.println(ctx.channel().id()+" left the chattingroom,"+"Online: "+channels.size());
        //将客户端的信息直接返回写入ctx
        ctx.write("server say :"+msg);
        //刷新缓存区
        ctx.flush();
        
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	System.out.println(ctx.channel().id()+" occurred into error,"+"Online: "+channels.size());
    	cause.printStackTrace();
        ctx.close();
    }
}
