package edu.nf.carsys.dao;

import edu.nf.carsys.entity.CarRnb;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LWP
 * @date 2019/11/25
 */
public interface CarRnbDao {

    List<CarRnb> getCarCodeList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    CarRnb getCarCodeByName(String carId);
    void deleteCarCode(String[] carId);
    void insertCarCode(CarRnb carCode);
    void updateCarCode(CarRnb carCode);
}