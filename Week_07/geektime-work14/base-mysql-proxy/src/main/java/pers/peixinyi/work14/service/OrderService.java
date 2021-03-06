package pers.peixinyi.work14.service;

import pers.peixinyi.work14.entity.Order;

import javax.sql.DataSource;
import java.util.List;

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
