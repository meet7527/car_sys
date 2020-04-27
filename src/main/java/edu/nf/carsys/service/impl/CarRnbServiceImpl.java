package edu.nf.carsys.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.dao.CarRnbDao;
import edu.nf.carsys.entity.CarRnb;
import edu.nf.carsys.service.CarRnbService;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LWP
 * @date 2019/11/25
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CarRnbServiceImpl implements CarRnbService {

    @Autowired
    private CarRnbDao dao;

    @Override
    public PageInfo<CarRnb> getList(Integer pageNum, Integer pageSize) {
        try{
            PageInfo<CarRnb> pageInfo = new PageInfo<>(dao.getCarCodeList(pageNum,pageSize));
            return pageInfo;
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public CarRnb getCarCodeByName(String carId) {
        try{
            return dao.getCarCodeByName(carId);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void deleteCarCode(String[] carId) {
        try{
            dao.deleteCarCode(carId);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void insertCarCode(CarRnb carCode) {
        try{
            dao.insertCarCode(carCode);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void updateCarCode(CarRnb carCode) {
        try{
            dao.updateCarCode(carCode);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }
}