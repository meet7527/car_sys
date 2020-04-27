package edu.nf.carsys.service;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.entity.Employees;

import javax.servlet.http.HttpSession;

/**
 * @author LWP
 * @date 2019/11/20
 */
public interface EmployeesService {
    PageInfo<Employees> getEmployees(Integer pageNum, Integer pageSize);
    void deleteEmployees(Integer[] id, HttpSession session);
    void insertEmployees(Employees employees, HttpSession session);
    Employees getEmployeesById(Integer id);
    void updateEmployees(Employees employees, HttpSession session);
    Employees getEmployeesByName(String name);
}