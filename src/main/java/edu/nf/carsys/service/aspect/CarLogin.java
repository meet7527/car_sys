package edu.nf.carsys.service.aspect;

import edu.nf.carsys.service.CarLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LWP
 * @date 2019/12/4
 */
@Aspect
@Component
public class CarLogin extends AbstractAspect {

    @Autowired
    private CarLogService carLogService;

    @After("login()")
    public void logins(JoinPoint pjp){
//        Admin admin = (Admin) pjp.getArgs()[0];
//        CarLog carLog = new CarLog();
//        carLog.setArea("用户"+admin.getUserName()+"登录了");
//        carLog.setLogTime(new Timestamp(System.currentTimeMillis()));
//        carLog.setUserName(admin.getUserName());
//        carLogService.insertCarport(carLog);
    }
}