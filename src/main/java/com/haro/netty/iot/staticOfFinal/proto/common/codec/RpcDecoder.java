package com.haro.netty.iot.staticOfFinal.proto.common.codec;

import com.haro.netty.iot.staticOfFinal.proto.common.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author 穆书伟
 * @description RPC 解码器
 * @date 2017/6/5 12:51
 */
public class RpcDecoder extends ByteToMessageDecoder{

    private Class<?> genericClass;

    public RpcDecoder(Class<?> genericClass){
        this.genericClass=genericClass;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if(byteBuf.readableBytes() < 4){
            return;
        }
        byteBuf.markReaderIndex();
        int dataLength = byteBuf.readInt();
        if(byteBuf.readableBytes() < dataLength){
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        byteBuf.readBytes(data);
        list.add(SerializationUtil.deserialize(data,genericClass));

    }
}
