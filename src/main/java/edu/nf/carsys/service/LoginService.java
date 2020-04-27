package edu.nf.carsys.service;

import edu.nf.carsys.entity.Admin;

/**
 * @author LWP
 * @date 2019/11/7
 */
public interface LoginService {
    Admin login(Admin admin);
    void addAdmin(Admin admin);
    void deleteAdmin(Integer[] id);
    void updateAdmin(Admin admin);
}