package pers.peixinyi.filter;

import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.impl.bootstrap.HttpServer;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 13:55
 */
public class FilterOne implements CustomFilter {

    public FilterOne() {
    }

    @Override
    public FullHttpRequest before(FullHttpRequest fullRequest) {
        System.out.println("FilterOne - Before:" + fullRequest.uri() + "\tMethod:" + fullRequest.method().name());

        return fullRequest;
    }

    @Override
    public FullHttpRequest after(FullHttpRequest fullRequest) {
        System.out.println("FilterOne - After:" + fullRequest.uri());
        return fullRequest;
    }
}
