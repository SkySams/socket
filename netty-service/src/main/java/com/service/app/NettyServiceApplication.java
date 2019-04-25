package com.service.app;

import java.net.InetSocketAddress;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.service.app.configs.NettyConfig;
import com.service.app.service.netty.NettyService;

@SpringBootApplication
public class NettyServiceApplication implements CommandLineRunner {

	@Autowired
	NettyService nettyService;
	
	@Autowired
	NettyConfig nettyConfig;
    

	public static void main(String[] args) {
		SpringApplication.run(NettyServiceApplication.class, args);
	}

	@Bean
	public NettyConfig createNettyConfig() {
		return new NettyConfig();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		InetSocketAddress inetSocketAddress = new InetSocketAddress(nettyConfig.getUrl(), nettyConfig.getPort());
		System.out.println("run "+nettyConfig.getUrl()+".... . ... " + nettyConfig.getPort());
		nettyService.start(inetSocketAddress);
	}

}
