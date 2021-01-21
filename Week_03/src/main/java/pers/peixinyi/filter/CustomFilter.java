package pers.peixinyi.filter;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Description: 自定义过滤器
 * @Author: PeiXy
 * @Date: 2021-01-21 13:16
 */
public interface CustomFilter {
    /**
     * <p> 消息之前过滤 </p>
     *
     * @param fullRequest 完整请求
     * @return void
     * @author PeiXy
     * @version 1.0.0.0
     * @since 13:48 2021/1/21
     */
    public FullHttpRequest before(FullHttpRequest fullRequest);

    /**
     * <p> 消息之后过滤 </p>
     *
     * @param fullRequest 完整请求
     * @return void
     * @author PeiXy
     * @version 1.0.0.0
     * @since 13:48 2021/1/21
     */
    public FullHttpRequest after(FullHttpRequest fullRequest);
}
