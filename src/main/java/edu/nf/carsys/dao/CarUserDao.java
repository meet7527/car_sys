package edu.nf.carsys.dao;

import edu.nf.carsys.entity.CarUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LWP
 * @date 2019/10/27
 */
public interface CarUserDao {

    List<CarUser> getListUser(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    void deleteUser(String[] id);
    void addUser(CarUser carUser);
    CarUser getUserById(String id);
    void update(CarUser carUser);
    List<CarUser> getListVip(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    void updateVipState(CarUser carUser);
}