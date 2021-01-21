package pers.peixinyi.router;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import pers.peixinyi.router.load.RatioAddress;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 15:06
 */
public class TwoRouter implements CustomRouter {
    @Override
    public void router(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {

    }

    @Override
    public String getPrefix() {
        return null;
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
