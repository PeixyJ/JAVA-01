package pers.peixinyi.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import pers.peixinyi.router.CustomRouter;
import pers.peixinyi.router.load.RatioAddress;

import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static org.apache.http.HttpHeaders.CONNECTION;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 16:57
 */
public class NotFoundHandler implements CustomRouter {
    @Override
    public void router(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        FullHttpResponse response = null;
        try {
            String value = "404 NOT_FOUND";
            response = new DefaultFullHttpResponse(HTTP_1_1, NOT_FOUND, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
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

    @Override
    public String getPrefix() {
        return null;
    }

    @Override
    public Boolean removePrefix() {
        return false;
    }

    @Override
    public String[] getAddress() {
        return new String[0];
    }

    @Override
    public RatioAddress[] getRatioAddress() {
        return new RatioAddress[0];
    }

}
