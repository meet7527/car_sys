package edu.nf.carsys.dao;

import edu.nf.carsys.entity.CarLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LWP
 * @date 2019/11/26
 */
public interface CarLogDao {

    List<CarLog> getCarportList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("userName") String userName);
    void insertCarport(CarLog carport);
    void deleteCarport(Integer[] id);
    List<CarLog> getCarportList2();
}