package pers.peixinyi.router;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import pers.peixinyi.router.load.RatioAddress;
import pers.peixinyi.utils.InvokingHttp;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 14:58
 */
public class BaiduRouter implements CustomRouter {

    @Override
    public String getPrefix() {
        return "/baidu/";
    }

    @Override
    public Boolean removePrefix() {
        return true;
    }

    @Override
    public String[] getAddress() {
        return new String[]{"http://www.baidu.com"};
    }

    @Override
    public RatioAddress[] getRatioAddress() {
        return new RatioAddress[0];
    }
}
