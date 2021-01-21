package pers.peixinyi.config;

import pers.peixinyi.filter.FilterChain;
import pers.peixinyi.filter.FilterOne;
import pers.peixinyi.filter.FilterTwo;
import pers.peixinyi.router.BaiduRouter;
import pers.peixinyi.router.CustomRouter;
import pers.peixinyi.router.GatewayRouter;
import pers.peixinyi.router.RouterChain;

/**
 * @Description: 自定义配置
 * @Author: PeiXy
 * @Date: 2021-01-21 13:54
 */
public class CustomConfig {

    public static void filterConfig() {
        FilterChain.filterList.add(0, new FilterOne());
        FilterChain.filterList.add(1, new FilterTwo());
    }

    public static void routerConfig() {
        CustomRouter baidu = new BaiduRouter();
        CustomRouter gatewayRouter = new GatewayRouter();
        RouterChain.routerMap.put(baidu.getPrefix(), baidu);
        RouterChain.routerMap.put(gatewayRouter.getPrefix(), gatewayRouter);
        RouterChain.sortMapList();
    }
}
