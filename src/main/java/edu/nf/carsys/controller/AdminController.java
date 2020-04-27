package edu.nf.carsys.controller;

import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.entity.Admin;
import edu.nf.carsys.entity.CarLog;
import edu.nf.carsys.service.CarLogService;
import edu.nf.carsys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/11/15
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class AdminController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CarLogService carLogService;

    @PostMapping("/adminLogin")
    public ResponseVo login(@Valid Admin admin, HttpSession session){
        Admin a = loginService.login(admin);
        session.setAttribute("admin",admin);
        return success(a,"登录成功");
    }

    @PostMapping("indexMsg")
    public ResponseVo index(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Admin a =loginService.login(admin);
        CarLog carLog = new CarLog();
        carLog.setArea("用户"+admin.getUserName()+"登录了");
        carLog.setLogTime(new Timestamp(System.currentTimeMillis()));
        carLog.setUserName(admin.getUserName());
        carLogService.insertCarport(carLog);
        return success(a);
    }
}