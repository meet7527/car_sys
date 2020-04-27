package edu.nf.carsys.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.dao.CarLogDao;
import edu.nf.carsys.entity.CarLog;
import edu.nf.carsys.service.CarLogService;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LWP
 * @date 2019/11/26
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CarLogServiceImpl implements CarLogService {

    @Autowired
    private CarLogDao dao;

    @Override
    public PageInfo<CarLog> getCarportList(Integer pageNum, Integer pageSize, String userName) {
        try{

            PageInfo<CarLog> pageInfo = new PageInfo<>(dao.getCarportList(pageNum,pageSize,userName));
            deleteCarport(deleteLog());
            return pageInfo;
        }catch(Exception e){
            throw new MyException("服务器异常");
        }

    }

    @Override
    public void insertCarport(CarLog carport) {
        try{
            dao.insertCarport(carport);

        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void deleteCarport(Integer[] id) {
        try{
            dao.deleteCarport(id);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public  List<CarLog> getCarportList2() {
        try{
            return dao.getCarportList2();

        }catch(Exception e){
            throw new MyException("服务器异常");
        }

    }

    public  Integer[] deleteLog(){
        Integer [] arrId = new Integer[1000];
        for(int i=0;i<getCarportList2().size();i++){
            CarLog carLog =getCarportList2().get(i);
            if((System.currentTimeMillis()- carLog.getLogTime().getTime()) / (24*60*60*1000) >= 7){
                arrId[i] = carLog.getId();
            }else {
                break;
            }
        }
        return arrId;
    }


}