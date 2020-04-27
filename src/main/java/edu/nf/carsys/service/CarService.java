package edu.nf.carsys.service;


import com.github.pagehelper.PageInfo;
import edu.nf.carsys.entity.CarUser;

import javax.servlet.http.HttpSession;


/**
 * @author LWP
 * @date 2019/11/5
 */
public interface CarService {

    PageInfo<CarUser> getCarUserLi(Integer pageNum, Integer pageSize);
    void deleteUser(String[] id, String port, HttpSession session);
    void addUser(CarUser carUser, HttpSession session);
    CarUser getUserById(String id);
    void update(CarUser carUser, HttpSession session);
    PageInfo<CarUser> getCarVip(Integer pageNum, Integer pageSize);
    Double getRmb(CarUser carUser, HttpSession session);
}