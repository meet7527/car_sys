package edu.nf.carsys.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.dao.OrderDao;
import edu.nf.carsys.entity.Order;
import edu.nf.carsys.entity.Port;
import edu.nf.carsys.service.OrderService;
import edu.nf.carsys.service.PortService;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LWP
 * @date 2019/12/3
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;

    @Autowired
    private PortService portService;



    @Override
    public PageInfo<Order> getOrderList(Integer pageNum, Integer pageSize) {
        try{
            PageInfo<Order> orderPageInfo = new PageInfo<>(dao.getOrderList(pageNum,pageSize));

            return orderPageInfo;
        }catch(Exception e){
            throw new MyException("服务器异常");
        }

    }

    @Override
    public void addOrder(Order order) {
        try{
            dao.addOrder(order);
            Port port = new Port();
            port.setPortNum(order.getPortNum());
            port.setPortIdentity("预约");
            port.setCarId("有预约");
            portService.updatePort(port);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void deleteOrder(Integer[] id,String port) {
        try{
            dao.deleteOrder(id);
            Port p = new Port();
            p.setPortIdentity("空");
            p.setCarId("没有");
            p.setPortNum(port);
            portService.updatePort(p);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void deleteOrder2(String port) {
        try{
            dao.deleteOrder2(port);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public Order getOrderById(Integer id) {
        try{

            return dao.getOrderById(id);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void updateOrder(Order order) {
        try{
            dao.updateOrder(order);
            Port p = new Port();
            p.setPortIdentity("预约");
            p.setCarId("有预约");
            p.setPortNum(order.getPortNum());
            portService.updatePort(p);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public Order getOrderByPort(String port) {
        try{
            return dao.getOrderByPort(port);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }

    }
}