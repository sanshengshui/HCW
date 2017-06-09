package com.haro.netty.iot.netty.handler;

import com.haro.netty.iot.staticOfFinal.proto.common.bean.RpcRequest;
import com.haro.netty.iot.staticOfFinal.proto.common.bean.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 穆书伟
 * @description 设备向服务器发送心跳包，20秒发一次心跳，保持TCP/UDP socket连接(心跳包可确保数据链路的实时建立)
 * 服务器向设备确认心跳包数据
 * @date 2017/6/8 17:22
 */
public class KeepAliveHandler extends SimpleChannelInboundHandler<RpcRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcRequest rpcRequest) throws Exception {
        RpcResponse response=new RpcResponse();
        response.setFrame_head("_YD_");
        response.setDir((byte)0x02);

    }
}
