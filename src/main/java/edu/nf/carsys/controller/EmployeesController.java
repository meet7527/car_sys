package edu.nf.carsys.controller;

import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.entity.Admin;
import edu.nf.carsys.entity.Employees;
import edu.nf.carsys.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author LWP
 * @date 2019/11/20
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class EmployeesController extends BaseController {

    @Autowired
    private EmployeesService service;

    @PostMapping("get_Employees")
    public ResponseVo getEmployees(Integer pageNum, Integer pageSize){
        return success(service.getEmployees(pageNum,pageSize));
    }

    @PostMapping("delete_employees")
    public ResponseVo delete(Integer[] id, HttpSession session){
        service.deleteEmployees(id,session);
        return success("删除成功");
    }

    @PostMapping("insert_employees")
    public ResponseVo insert(@Valid Employees e, HttpSession session){
        service.insertEmployees(e,session);
        return success("添加成功");
    }

    @PostMapping("getEmployees_byId")
    public ResponseVo getEmployeesById(Integer id){
        Employees employees = service.getEmployeesById(id);
        return success(employees);
    }

    @PostMapping("update_employees")
    public ResponseVo update(Employees e, HttpSession session){
        service.updateEmployees(e,session);
        return success("修改成功");
    }

    @PostMapping("getEmployees_byName")
    public ResponseVo getEmployeByName(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Employees e = service.getEmployeesByName(admin.getUserName());
        return success(e);
    }



}