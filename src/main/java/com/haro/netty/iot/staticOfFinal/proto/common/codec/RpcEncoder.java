package com.haro.netty.iot.staticOfFinal.proto.common.codec;

import com.haro.netty.iot.staticOfFinal.proto.common.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author 穆书伟
 * @description 编码器
 * @date 2017/6/5 12:41
 */
public class RpcEncoder extends MessageToByteEncoder{
    private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass){
        this.genericClass=genericClass;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        if(genericClass.isInstance(o)){
            byte[] data= SerializationUtil.serialize(o);
            byteBuf.writeInt(data.length);
            byteBuf.writeBytes(data);
        }
    }
}
