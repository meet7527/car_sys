package edu.nf.carsys.service.impl;

import edu.nf.carsys.dao.AdminLogin;
import edu.nf.carsys.entity.Admin;
import edu.nf.carsys.service.LoginService;
import edu.nf.carsys.service.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LWP
 * @date 2019/11/7
 */
@Service("loginService")
@Transactional(rollbackFor = RuntimeException.class)
public class LoginServiceImpl implements LoginService {

    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private AdminLogin dao;

    @Override
    public Admin login(Admin admin) {
        logger.info("登录验证");
        Admin a = dao.adminLogin(admin);
        if(a==null){
            throw new MyException("账号，或密码错误");
        }else {
            if (admin.getUserName().equals(a.getUserName()) && admin.getPass().equals(a.getPass())) {
                System.out.println(a.getIdentity());
                return a;
            }
            throw new MyException("账号，或密码错误");
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        try{
            dao.addAdmin(admin);
        }catch(Exception e){
            throw new MyException("添加失败");
        }
    }

    @Override
    public void deleteAdmin(Integer[] id) {
        try{
            dao.deleteAdmin(id);
        }catch(Exception e){
            throw new MyException("出现异常");
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        try{
            dao.updateAdmin(admin);
        }catch(Exception e){
            throw new MyException("出现异常");
        }
    }
}