package edu.nf.carsys.service.aspect;

import edu.nf.carsys.entity.Admin;
import edu.nf.carsys.entity.CarLog;
import edu.nf.carsys.service.CarLogService;
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
public class EmployeesServiceAspect extends AbstractAspect {

    @Autowired
    private CarLogService carportService;


    @AfterReturning(value = "delEmp()")
    public void delEmploy(JoinPoint pjp){
        Object[] obj = pjp.getArgs();
        addLog((HttpSession) obj[1],"删除管理员");
    }

    @AfterReturning(value = "addEmp()")
    public void addEmploy(JoinPoint pjp){
        Object[] obj = pjp.getArgs();
        addLog((HttpSession) obj[1],"添加管理员");
    }

    @AfterReturning(value = "updEmp()")
    public void updEmploy(JoinPoint pjp){
        Object[] obj = pjp.getArgs();
        addLog((HttpSession) obj[1],"修改管理员信息");
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
}