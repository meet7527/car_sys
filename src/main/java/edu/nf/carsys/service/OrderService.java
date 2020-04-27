package edu.nf.carsys.service;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.entity.Order;

/**
 * @author LWP
 * @date 2019/12/3
 */
public interface OrderService {

    PageInfo<Order> getOrderList(Integer pageNum, Integer pageSize);
    void addOrder(Order order);
    void deleteOrder(Integer[] id, String port);
    void deleteOrder2(String port);
    Order getOrderById(Integer id);
    void updateOrder(Order order);
    Order getOrderByPort(String port);
}