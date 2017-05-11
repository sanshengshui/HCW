package com.haro.netty.iot.staticOfFinal;


import io.netty.channel.socket.SocketChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/4/23.
 */
public class NettyChannelMap {
    public static Map<String,SocketChannel> channelMap=new ConcurrentHashMap<String, SocketChannel>();
}
