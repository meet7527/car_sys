package edu.nf.carsys.dao;

import edu.nf.carsys.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LWP
 * @date 2019/12/3
 */
public interface OrderDao {

    List<Order> getOrderList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    void addOrder(Order order);
    void deleteOrder(Integer[] id);
    void deleteOrder2(String portNum);
    Order getOrderById(Integer id);
    void updateOrder(Order order);
    Order getOrderByPort(String port);
}