package pers.peixinyi.filter;

import io.netty.handler.codec.http.FullHttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 13:15
 */
public class FilterChain {
    /**
     * 过滤器列表
     * 优先级越高则在
     * Before更早执行
     * After 更晚执行
     */
    public static List<CustomFilter> filterList = new ArrayList<>();

    public void doBefore(FullHttpRequest fullRequest) {
        for (CustomFilter filter : filterList) {
            fullRequest = filter.before(fullRequest);
        }
    }

    public void doAfter(FullHttpRequest fullRequest) {
        for (int i = filterList.size(); i > 0; i--) {
            fullRequest = filterList.get(i - 1).after(fullRequest);
        }
    }
}
