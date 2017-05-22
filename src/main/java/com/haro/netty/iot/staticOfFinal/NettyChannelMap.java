package com.haro.netty.iot.staticOfFinal;


import io.netty.channel.socket.SocketChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * @author 穆书伟
 * @description 将设备的mac地址和socket绑定到一起 利用此socket向设备发送数据
 * @date 2017/5/22 18:43
 */
public class NettyChannelMap {
    public static Map<String,SocketChannel> channelMap=new ConcurrentHashMap<String, SocketChannel>();

    public static Map<SocketChannel,String> comidMap=new ConcurrentHashMap<SocketChannel, String>();
}
