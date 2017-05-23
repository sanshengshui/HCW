package com.haro.netty.iot.netty.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


import java.io.IOException;
import java.sql.*;


/**
 * 
* @ClassName: StringProtocolInitalizer  
* @Description: TODO  Just a dummy protocol mainly to show the ServerBootstrap being initialized.
* @author 穆书伟
* @Email shanyulian@aliyun.com 
* @date 2017年1月13日 上午10:27:24
 */
@Component
@Qualifier("springProtocolInitializer")
public class StringProtocolInitalizer extends ChannelInitializer<SocketChannel>{

	@Autowired
	StringDecoder stringDecoder;

	@Autowired
	StringEncoder stringEncoder;

	@Autowired
	ServerHandler serverHandler;


	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();


		pipeline.addLast("handler", serverHandler);
		pipeline.addLast("heartbeatHandler",new HeartbeatHandler(25));//心跳包检测机制60s
	}



	public StringDecoder getStringDecoder() {
		return stringDecoder;
	}

	public void setStringDecoder(StringDecoder stringDecoder) {
		this.stringDecoder = stringDecoder;
	}

	public StringEncoder getStringEncoder() {
		return stringEncoder;
	}

	public void setStringEncoder(StringEncoder stringEncoder) {
		this.stringEncoder = stringEncoder;
	}

	public ServerHandler getServerHandler() {
		return serverHandler;
	}

	public void setServerHandler(ServerHandler serverHandler) {
		this.serverHandler = serverHandler;
	}







}
