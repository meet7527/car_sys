package edu.nf.carsys.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.dao.EmployeesDao;
import edu.nf.carsys.entity.Admin;
import edu.nf.carsys.entity.Employees;
import edu.nf.carsys.service.CarLogService;
import edu.nf.carsys.service.EmployeesService;
import edu.nf.carsys.service.LoginService;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @author LWP
 * @date 2019/11/20
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesDao dao;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CarLogService carportService;

    @Override
    public PageInfo<Employees> getEmployees(Integer pageNum, Integer pageSize) {
        try{
            PageInfo<Employees> pageInfo = new PageInfo<>(dao.getEmployees(pageNum,pageSize));
            return pageInfo;
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public void deleteEmployees(Integer[] id, HttpSession session) {
        try{
            dao.deleteEmployees(id);
            loginService.deleteAdmin(id);
        }catch(Exception e){
            throw new MyException("删除失败，服务器异常");
        }
    }

    @Override
    public void insertEmployees(Employees employees, HttpSession session) {
        try{
            dao.insertEmployees(employees);
            Admin admin = new Admin();
            admin.setUserName(employees.getEmployName());
            admin.setIdentity(employees.getPosid());
            loginService.addAdmin(admin);
        }catch(Exception e){
            throw new MyException("添加失败，服务器异常");
        }

    }

    @Override
    public Employees getEmployeesById(Integer id) {
        try{
            return dao.getById(id);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }

    }

    @Override
    public void updateEmployees(Employees employees, HttpSession session) {
        try{
            dao.updateEmployees(employees);
            Admin admin = new Admin();
            admin.setId(employees.getEmployId());
            admin.setUserName(employees.getEmployName());
            admin.setIdentity(employees.getPosid());
            admin.setPass(employees.getPass());
            loginService.updateAdmin(admin);
        }catch(Exception e){
            throw new MyException("修改失败，服务器异常");
        }
    }

    @Override
    public Employees getEmployeesByName(String name) {
        try{
            return dao.getByName(name);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }
}