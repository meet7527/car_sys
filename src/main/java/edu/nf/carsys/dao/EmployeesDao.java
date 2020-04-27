package edu.nf.carsys.dao;

import edu.nf.carsys.entity.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LWP
 * @date 2019/11/20
 */
public interface EmployeesDao {
    List<Employees> getEmployees(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    void deleteEmployees(Integer[] id);
    void insertEmployees(Employees employees);
    Employees getById(Integer id);
    void updateEmployees(Employees employees);
    Employees getByName(String name);
}