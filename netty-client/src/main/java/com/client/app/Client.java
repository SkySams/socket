package com.client.app;

import java.util.Scanner;

import com.client.app.handler.ChannelHandler;
import com.client.app.initializer.ClientChannelInitializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class Client {

	static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "9121"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws Exception {
        sendMessage("nice OK!!!!!!");
    }
  
    public static void sendMessage(String content) throws InterruptedException{
        // Configure the client
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap()
                    .group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ClientChannelInitializer());

            ChannelFuture future = b.connect(HOST, PORT).sync();
          /*  future.channel().writeAndFlush(content);*/
            Scanner sca=new Scanner(System.in);
            while (true){
                String str=sca.nextLine();//输入的内容
                if (str.equals("exit"))
                    break;//如果是exit则退出
                future.channel().writeAndFlush("-:-"+str);//将名字和信息内容一起发过去
            }
            future.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }


}
