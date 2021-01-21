package pers.peixinyi.filter;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 13:55
 */
public class FilterTwo implements CustomFilter {

    public FilterTwo() {
    }

    @Override
    public FullHttpRequest before(FullHttpRequest fullRequest) {
        System.out.println("FilterTwo - Before:" + fullRequest.uri());
        return fullRequest;
    }

    @Override
    public FullHttpRequest after(FullHttpRequest fullRequest) {
        System.out.println("FilterTwo - After:" + fullRequest.uri());
        return fullRequest;
    }
}
