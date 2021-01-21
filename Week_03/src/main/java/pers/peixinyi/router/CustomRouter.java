package pers.peixinyi.router;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import pers.peixinyi.router.load.RatioAddress;

import java.util.List;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @Description: 路由器
 * @Author: PeiXy
 * @Date: 2021-01-21 14:45
 */
public interface CustomRouter {
    /**
     * <p> 进行路由 </p>
     *
     * @param fullRequest
     * @param ctx
     * @return void
     * @author PeiXy
     * @version 1.0.0.0
     * @since 14:48 2021/1/21
     */
    void router(FullHttpRequest fullRequest, ChannelHandlerContext ctx);

    /**
     * <p> url前缀 </p>
     *
     * @return java.lang.String
     * @author PeiXy
     * @version 1.0.0.0
     * @since 14:50 2021/1/21
     */
    String getPrefix();

    String[] getAddress();

    RatioAddress[] getRatioAddress();

    default void writeResponse(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String context, HttpResponseStatus status) {
        FullHttpResponse response = null;
        try {
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(context.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());

        } catch (Exception e) {
            System.out.println("处理出错:" + e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
            }
        }
    }
}
