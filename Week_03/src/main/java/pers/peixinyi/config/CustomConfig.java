package pers.peixinyi.config;

import pers.peixinyi.filter.CustomFilter;
import pers.peixinyi.filter.FilterChain;
import pers.peixinyi.filter.FilterOne;
import pers.peixinyi.filter.FilterTwo;
import pers.peixinyi.router.CustomRouter;
import pers.peixinyi.router.OneRouter;
import pers.peixinyi.router.RouterChain;

import java.util.List;

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
        OneRouter baidu = new OneRouter();
        RouterChain.routerMap.put(baidu.getPrefix(), new OneRouter());
        RouterChain.routerMap.put("/url2/", new OneRouter());
        RouterChain.sortMapList();
    }
}
