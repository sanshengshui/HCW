package com.haro.netty.iot.netty.handler;


import com.haro.netty.iot.staticOfFinal.NettyChannelMap;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;




import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


import static com.haro.netty.util.ByteUtil.Str2Hex;
import static com.haro.netty.util.ByteUtil.bytesToHexString;

/**
 * 
* @ClassName: ServerHandler  
* @Description: TODO  netty 重要接口
* @author 穆书伟
* @Email lovewsic@gmail.com
* @date 2017年1月13日 上午10:21:42
 */
@Component
@Qualifier("serverHandler")
@Sharable
public class ServerHandler extends  ChannelInboundHandlerAdapter {



	private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

	/**
	 * 客户的登入
	 */
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelRegistered(ctx);
		logger.info("client: "+ ctx.channel().remoteAddress()+ "channelRegistered");

	}
	/**
	 * 客户端退出
	 */
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelUnregistered(ctx);


	}
	/**
	 * 客户接入
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelActive(ctx);

		logger.info("client: "+ ctx.channel().remoteAddress()+ "channelInactive");





	}
	/**
	 * 客户端断开
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
		logger.info("client: "+ ctx.channel().remoteAddress()+ "channelInactive");


	}



	/**
	 * 接受到数据
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		//super.channelRead(ctx, msg);


		//获取byte数据
		  ByteBuf in = (ByteBuf) msg;
		  byte[]req = new byte[in.readableBytes()];
		  int ReqLength=req.length;
		  in.readBytes(req);
		  /*
		  byte a=(0x45);
		  char c=(char)a;
		  System.out.println(c);
		  */


		  if(req.length==27){
		  	byte[] reqYaDu=new byte[13];
		  	char[] buffermu=new char[26];
		  	for(int i=0;i<26;i++){
		  		buffermu[i]=(char)req[i];
			}
			Str2Hex(buffermu,reqYaDu,26);
			  String strReqYaDu=bytesToHexString(reqYaDu);
			  logger.info(strReqYaDu);



			  byte[] rcDatab=new byte[45];
			  rcDatab[0]=(byte)0x5F;
			  rcDatab[1]=(byte)0x59;
			  rcDatab[2]=(byte)0x44;
			  rcDatab[3]=(byte)0x5F;
			  rcDatab[4]=(byte)0x02;
			  System.arraycopy(reqYaDu,0,rcDatab,5,13);
			  byte[] rcD=new byte[]{0x38,0x39,0x38,0x36,0x30,0x36,0x31,0x36,0x30,0x32,0x30,0x30,0x34,0x32,0x36,0x38,0x39,0x35,0x37,0x35};
			  System.arraycopy(rcD,0,rcDatab,18,20);
			  rcDatab[38]=(byte)0x03;
			  rcDatab[39]=(byte)0xF2;
			  rcDatab[40]=(byte)0x01;
			  rcDatab[41]=(byte)0x00;
			  if(req[ReqLength-1]==(byte)0x31){
				  rcDatab[42]=(byte)0x01;
			  }else if(req[ReqLength-1]==(byte)0x32){
				  rcDatab[42]=(byte)0x02;
			  }else  if(req[ReqLength-1]==(byte)0x33){
				  rcDatab[42]=(byte)0x03;
			  }else if(req[ReqLength-1]==(byte)0x34){
				  rcDatab[42]=(byte)0x04;
			  }
			  rcDatab[43]=(byte)0x23;
			  rcDatab[44]=(byte)0x23;
			  ByteBuf encodedw=ctx.alloc().buffer(45);
			  encodedw.writeBytes(rcDatab);
			NettyChannelMap.channelMap.get(strReqYaDu).write(encodedw);
			NettyChannelMap.channelMap.get(strReqYaDu).flush();





		  }





			if(req[0]==(byte)0x5F && req[1]==(byte)0x59 && req[2]==(byte)0x44 &&req[3]==(byte)0x5F && req[ReqLength-1]==(byte)0x23 && req[ReqLength-2]==(byte)0x23){





			  byte[] reqData=new byte[44];
			  reqData[0]=(byte)0x5F;
			  reqData[1]=(byte)0x59;
			  reqData[2]=(byte)0x44;
			  reqData[3]=(byte)0x5F;
			  reqData[4]=(byte)0x02;
			  System.arraycopy(req,5,reqData,5,13);
			  System.arraycopy(req,18,reqData,18,20);

			  reqData[38]=(byte)0x03;
			  reqData[39]=(byte)0xF6;
			  reqData[40]=(byte)0x00;
			  reqData[41]=(byte)0x00;
			  reqData[42]=(byte)0x23;
			  reqData[43]=(byte)0x23;

			  byte[] reqDataT=new byte[13];
			  System.arraycopy(req,5,reqDataT,0,13);
			  String reqDataTe=bytesToHexString(reqDataT);
			 NettyChannelMap.channelMap.put(reqDataTe,(SocketChannel) ctx.channel());
			  logger.info(reqDataTe);





		  	if(req[38]==(byte)0x03){
			}
			if(req[39]==(byte)0xF3){
			}else if(req[39]==(byte)0xF5){
				ByteBuf encoded=ctx.alloc().buffer(44);
				encoded.writeBytes(reqData);
				ctx.write(encoded);
				ctx.flush();
				String reqdata=bytesToHexString(reqData);
				logger.info(reqdata);
			}else if(req[39]==(byte)0xF1){
			}
		  }

	}
	/**
     * ctx.write(Object)方法不会使消息写入到通道上，
     * 他被缓冲在了内部，你需要调用ctx.flush()方法来把缓冲区中数据强行输出。
     * 或者你可以在channelRead方法中用更简洁的cxt.writeAndFlush(msg)以达到同样的目的
     * @param ctx
     * @throws Exception
     */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelReadComplete(ctx);
		   ctx.flush();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelWritabilityChanged(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}



}
