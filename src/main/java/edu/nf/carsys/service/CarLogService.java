package edu.nf.carsys.service;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.entity.CarLog;

import java.util.List;


/**
 * @author LWP
 * @date 2019/11/26
 */
public interface CarLogService {

    PageInfo<CarLog> getCarportList(Integer pageNum, Integer pageSize, String userName);
    void insertCarport(CarLog carport);
    void deleteCarport(Integer[] id);
     List<CarLog> getCarportList2();
}