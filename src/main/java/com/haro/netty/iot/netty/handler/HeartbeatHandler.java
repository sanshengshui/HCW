package com.haro.netty.iot.netty.handler;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutException;

/**
 * 
* @ClassName: HeartbeatHandler  
* @Description: TODO  netty 心跳包检测机制
* @author 穆书伟
* @Email lovewsic@gmail.com
* @date 2017年1月13日 上午10:51:57
 */

public class HeartbeatHandler extends IdleStateHandler{
	 private boolean closed;

	    /**
	     * Creates a new instance.
	     *
	     * @param timeoutSeconds
	     *        read timeout in seconds
	     */
	    public HeartbeatHandler(int timeoutSeconds) {
	        this(timeoutSeconds, TimeUnit.SECONDS);
	    }

	    /**
	     * Creates a new instance.
	     *
	     * @param timeout
	     *        read timeout
	     * @param unit
	     *        the {@link TimeUnit} of {@code timeout}
	     */
	    public HeartbeatHandler(long timeout, TimeUnit unit) {
	        super(timeout, 0, 0, unit);
	    }

	    @Override
	    protected final void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
	        assert evt.state() == IdleState.READER_IDLE;
	        readTimedOut(ctx);
	    }

	    /**
	     * Is called when a read timeout was detected.
	     */
	    protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
	        if (!closed) {
	            ctx.fireExceptionCaught(ReadTimeoutException.INSTANCE);
	            ctx.close();
	            closed = true;
	        }
	    }
}
