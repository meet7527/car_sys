package edu.nf.carsys.controller;

import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.entity.Order;
import edu.nf.carsys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LWP
 * @date 2019/12/3
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping("get_orderList")
    public ResponseVo getListOrder(Integer pageNum, Integer pageSize){
        return success(orderService.getOrderList(pageNum,pageSize));
    }

    @PostMapping("add_order")
    public ResponseVo addOrder(Order order){
        orderService.addOrder(order);
        return success("预约成功");
    }

    @PostMapping("delete_order")
    public ResponseVo deleteOrder(Integer[] id, String port){
        orderService.deleteOrder(id,port);
        return success("删除成功");
    }

    @PostMapping("get_orderById")
    public ResponseVo getOrderById(Integer id){
        return success(orderService.getOrderById(id));
    }

    @PostMapping("update_order")
    public ResponseVo updateOrder(Order order) {
        orderService.updateOrder(order);
        return success("修改成功");
    }

    @PostMapping("get_orderByPort")
    public ResponseVo getOrderByPort(String port){
        return success(orderService.getOrderByPort(port));
    }
}