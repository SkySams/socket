package com.service.app.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.netty")
public class NettyConfig {
	
	private int port;
	private int bossThreads;
	private int workThreads;
	private int workIoRatio;
	private long writeIdle;
    private long readIdle;
    private long allIdle;
    private int coreSize;
    private int maxSize;
    private long keepAlive;
    private String url;
    //操作系统类型：1 windows、2 linux
    private int systemType;
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getBossThreads() {
		return bossThreads;
	}
	public void setBossThreads(int bossThreads) {
		this.bossThreads = bossThreads;
	}
	public int getWorkThreads() {
		return workThreads;
	}
	public void setWorkThreads(int workThreads) {
		this.workThreads = workThreads;
	}
	public int getWorkIoRatio() {
		return workIoRatio;
	}
	public void setWorkIoRatio(int workIoRatio) {
		this.workIoRatio = workIoRatio;
	}
	public long getWriteIdle() {
		return writeIdle;
	}
	public void setWriteIdle(long writeIdle) {
		this.writeIdle = writeIdle;
	}
	public long getReadIdle() {
		return readIdle;
	}
	public void setReadIdle(long readIdle) {
		this.readIdle = readIdle;
	}
	public long getAllIdle() {
		return allIdle;
	}
	public void setAllIdle(long allIdle) {
		this.allIdle = allIdle;
	}
	public int getCoreSize() {
		return coreSize;
	}
	public void setCoreSize(int coreSize) {
		this.coreSize = coreSize;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public long getKeepAlive() {
		return keepAlive;
	}
	public void setKeepAlive(long keepAlive) {
		this.keepAlive = keepAlive;
	}
	public int getSystemType() {
		return systemType;
	}
	public void setSystemType(int systemType) {
		this.systemType = systemType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
