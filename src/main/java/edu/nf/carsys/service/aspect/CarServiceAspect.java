package edu.nf.carsys.service.aspect;

import edu.nf.carsys.entity.*;
import edu.nf.carsys.service.CarLogService;
import edu.nf.carsys.service.CarRnbService;
import edu.nf.carsys.service.PortService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/11/27
 */
@Aspect
@Component
public class CarServiceAspect extends AbstractAspect {

    @Autowired
    private CarLogService carportService;

    @Autowired
    private CarRnbService carCodeService;

    @Autowired
    private PortService service;

    @AfterReturning(value = "del()")
    public void delUser(JoinPoint pjp){
        Object[] obj = pjp.getArgs();
        carCodeService.deleteCarCode((String[]) obj[0]);
        addLog((HttpSession) obj[2],"删除成功");

        Port p = new Port();
        p.setPortIdentity("空");
        p.setCarId("没有");
        p.setPortNum((String) obj[1]);
        service.updatePort(p);
    }

    @AfterReturning(value = "add()")
    public void addUser(JoinPoint pjp){
        Object[] obj = pjp.getArgs();
        CarUser carUser = (CarUser) obj[0];
        CarRnb carCode = carUserSy(carUser);
        carCodeService.insertCarCode(carCode);
        addLog((HttpSession) obj[1],"添加了客户");
        Port p = new Port();
        p.setPortIdentity("非空");
        p.setCarId(carUser.getCarId());
        p.setPortNum(carUser.getPortNum());
        service.updatePort(p);
    }

    @AfterReturning(value = "upU()")
    public void updateUser(JoinPoint pjp){
        Object[] obj = pjp.getArgs();
        CarUser carUser = (CarUser) obj[0];
        CarRnb carCode = carUserSy(carUser);
        carCodeService.updateCarCode(carCode);
        addLog((HttpSession) obj[1],"修改了客户");

        Port p = new Port();
        p.setPortIdentity("非空");
        p.setCarId(carUser.getCarId());
        p.setPortNum(carUser.getPortNum());
        service.updatePort(p);

    }

    private void addLog(HttpSession session, String message){
        Admin admin = (Admin)session.getAttribute("admin");
        CarLog carport = new CarLog();
        carport.setArea(message);
        carport.setUserName(admin.getUserName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        carport.setLogTime(timestamp);
        carportService.insertCarport(carport);
    }

    private CarRnb carUserSy(CarUser carUser){
        CarRnb carCode = new CarRnb();
        carCode.setCar_id(carUser.getCarId());
        carCode.setCar_vip(carUser.getCarVip());
        carCode.setPhoneNum(carUser.getUserTel());
        carCode.setUserName(carUser.getUserName());
        carCode.setStopTime(carUser.getStopTime());
        carCode.setMoney(0);
        return carCode;
    }
}