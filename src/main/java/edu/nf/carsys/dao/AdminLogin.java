package edu.nf.carsys.dao;

import edu.nf.carsys.entity.Admin;

/**
 * @author LWP
 * @date 2019/11/7
 */
public interface AdminLogin {
    Admin adminLogin(Admin admin);
    void addAdmin(Admin admin);
    void deleteAdmin(Integer[] id);
    void updateAdmin(Admin admin);
}