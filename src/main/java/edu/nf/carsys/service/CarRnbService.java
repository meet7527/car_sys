package edu.nf.carsys.service;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.entity.CarRnb;

/**
 * @author LWP
 * @date 2019/11/25
 */
public interface CarRnbService {

    PageInfo<CarRnb> getList(Integer pageNum, Integer pageSize);
    CarRnb getCarCodeByName(String carId);
    void deleteCarCode(String[] carId);
    void insertCarCode(CarRnb carCode);
    void updateCarCode(CarRnb carCode);
}