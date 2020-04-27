package edu.nf.carsys.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.dao.CarUserDao;
import edu.nf.carsys.entity.CarUser;
import edu.nf.carsys.service.CarRnbService;
import edu.nf.carsys.service.CarService;
import edu.nf.carsys.service.OrderService;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @author LWP
 * @date 2019/11/5
 */
@Service("carService")
@Transactional(rollbackFor = RuntimeException.class)
public class CarServiceImpl implements CarService {

    @Autowired
    private CarUserDao dao;

    @Autowired
    private CarRnbService service;

    @Autowired
    private OrderService orderService;

    @Override
    public PageInfo<CarUser> getCarUserLi(Integer pageNum, Integer pageSize) {
        try{
            PageInfo<CarUser> pageInfo = new PageInfo<>(dao.getListUser(pageNum,pageSize));
            return pageInfo;
        }catch(Exception e){
            throw new MyException("数据查询异常");
        }
    }
    @Override
    public void deleteUser(String[] id,String port, HttpSession session) {
        try{
            dao.deleteUser(id);
        }catch(Exception e){
            throw new MyException("删除失败，请选择");
        }
    }
    @Override
    public void addUser(CarUser carUser, HttpSession session) {
        try{
            dao.addUser(carUser);
            orderService.deleteOrder2(carUser.getPortNum());
        }catch(Exception e){
            throw new MyException("添加失败");
        }
    }
    @Override
    public CarUser getUserById(String id) {
        try{
            return dao.getUserById(id);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void update(CarUser carUser, HttpSession session) {
        try{
            dao.update(carUser);
        }catch(Exception e){
            throw new MyException("修改失败，请重试");
        }
    }

    @Override
    public PageInfo<CarUser> getCarVip(Integer pageNum, Integer pageSize) {
        try{
            PageInfo<CarUser> pageInfo = new PageInfo<>(dao.getListVip(pageNum,pageSize));
            return pageInfo;
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public Double getRmb(CarUser carUser, HttpSession session) {
        try{
            Long time =  System.currentTimeMillis()-carUser.getStopTime().getTime();
            double d = time/(1000*60);
            String[] carId = {carUser.getCarId()};
            //deleteUser(carId,session);
            return d;
        }catch(Exception e){
            throw new MyException("异常");
        }
    }
}