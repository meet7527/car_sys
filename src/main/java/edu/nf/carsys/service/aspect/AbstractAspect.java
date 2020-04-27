package edu.nf.carsys.service.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author wangl
 * @date 2019/10/30
 */
public class AbstractAspect {
    /**
     * 声明切入点， @Pointcut声明在一个方法上
     */
    @Pointcut("execution(* edu.nf.carsys.service.impl.CarServiceImpl.deleteUser(..))")
    protected void del(){
    }

    @Pointcut("execution(* edu.nf.carsys.service.impl.CarServiceImpl.addUser(..))")
    protected void add(){
    }

    @Pointcut("execution(* edu.nf.carsys.service.impl.CarServiceImpl.update(..))")
    protected void upU(){
    }

    @Pointcut("execution(* edu.nf.carsys.service.impl.EmployeesServiceImpl.deleteEmployees(..))")
    protected void delEmp(){
    }

    @Pointcut("execution(* edu.nf.carsys.service.impl.EmployeesServiceImpl.insertEmployees(..))")
    protected void addEmp(){
    }

    @Pointcut("execution(* edu.nf.carsys.service.impl.EmployeesServiceImpl.updateEmployees(..))")
    protected void updEmp(){
    }

    @Pointcut("execution(* edu.nf.carsys.service.impl.LoginServiceImpl.login(..))")
    protected void login(){
    }

}
