package pers.peixinyi.router;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import pers.peixinyi.router.load.RatioAddress;
import pers.peixinyi.utils.InvokingHttp;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 15:06
 */
public class GatewayRouter implements CustomRouter {

    @Override
    public String getPrefix() {
        return "/api/";
    }

    @Override
    public Boolean removePrefix() {
        return false;
    }

    @Override
    public String[] getAddress() {
        return new String[]{"http://127.0.0.1:8088"};
    }

    @Override
    public RatioAddress[] getRatioAddress() {
        return new RatioAddress[0];
    }

}
