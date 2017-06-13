package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DatagramPacketDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 穆书伟
 * @description Simple client for module test
 * @date 2017/6/13 下午16:05:22
 */
public class Client {
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8090"));
    public static final int clientNum = Integer.parseInt(System.getProperty("size", "10"));
    public static final int frequency = 100;  //ms

    public static void main(String[] args) throws Exception{
        beginPressTest();
    }

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void beginPressTest() throws InterruptedException{
        EventLoopGroup group = new NioEventLoopGroup();
          Bootstrap b = new Bootstrap();
          b.group(group)
                  .channel(NioSocketChannel.class)
                  .option(ChannelOption.TCP_NODELAY,true)
                  .handler(new ChannelInitializer<SocketChannel>() {
                      @Override
                      protected void initChannel(SocketChannel socketChannel) throws Exception {
                          ChannelPipeline p=socketChannel.pipeline();
                          //



                      }
                  });
          // Start the client

          for (int i=1;i<clientNum;i++){
              startConnection(b,i);

          }


    }

    public static void startConnection(Bootstrap b, final int index){

        b.connect(HOST,PORT)
                .addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if(channelFuture.isSuccess()){
                            //init registry
                            logger.error("Client[{}] connected Gate Success...",index);

                        }else {
                            logger.error("Client[{}] connected Gate Failed",index);
                        }
                    }
                });
    }
}
