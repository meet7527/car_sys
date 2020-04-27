package edu.nf.carsys.controller.advice;

import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LWP
 * @date 2019/11/15
 */
@ControllerAdvice("edu.nf.carsys.controller")
public class AdviceException<T> {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResponseVo<T> loginException(MyException e){
        ResponseVo vo = new ResponseVo();
        vo.setCode(20000);
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseVo<T> formException(org.springframework.validation.BindException e){
        ResponseVo vo = new ResponseVo();
        Map<String,String> map= new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(map);
        return vo;
    }
}