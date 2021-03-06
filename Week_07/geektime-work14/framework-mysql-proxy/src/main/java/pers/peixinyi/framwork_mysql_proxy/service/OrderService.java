package pers.peixinyi.framwork_mysql_proxy.service;


import pers.peixinyi.framwork_mysql_proxy.entity.Order;

import javax.sql.DataSource;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 14:36
 */
public interface OrderService {
    /**
     * 新增订单
     *
     * @param dataSource
     * @param order
     */
    public Boolean addOrder(DataSource dataSource, Order order);

    /**
     * 根据Id获取订单
     *
     * @param dataSource
     * @param orderId
     * @return
     */
    public Order getOrdersById(DataSource dataSource, String orderId);
}
