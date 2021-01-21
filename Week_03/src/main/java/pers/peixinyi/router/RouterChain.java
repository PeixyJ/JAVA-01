package pers.peixinyi.router;

import com.sun.tools.javac.util.ArrayUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import pers.peixinyi.handler.NotFoundHandler;
import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * @Description: 路由设置
 * @Author: PeiXy
 * @Date: 2021-01-21 14:43
 */
public class RouterChain {
    public static Map<String, CustomRouter> routerMap = new HashMap<>();
    public static List<String> MapList = new ArrayList<>();


    public void doRouter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        for (int i = 0; i < MapList.size(); i++) {
            if (fullRequest.uri().contains(MapList.get(i))) {
                routerMap.get(MapList.get(i)).router(fullRequest, ctx);
                return;
            }
        }
        new NotFoundHandler().router(fullRequest, ctx);
    }

    /**
     * <p> Url对比 </p>
     *
     * @return void
     * @author PeiXy
     * @version 1.0.0.0
     * @since 15:32 2021/1/21
     */
    public static void sortMapList() {
        List<String> realList = new ArrayList<>(routerMap.keySet());
        List<String> sortList = new ArrayList<>();
        for (int i = 0; i < realList.size(); i++) {
            int index = -1;
            for (int j = 0; j < realList.size(); j++) {
                if (realList.get(i).length() < realList.get(j).length()) {
                    index = j;
                }
            }
            if (index != -1) {
                sortList.add(i, realList.get(index));
                realList.set(index, "");
            } else {
                sortList.add(i, realList.get(i));
                realList.set(i, "");
            }
        }
        MapList = sortList;
    }
}
