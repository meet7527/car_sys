package edu.nf.carsys.controller;

import edu.nf.carsys.controller.vo.ResponseVo;
import org.springframework.http.HttpStatus;

/**
 * @author LWP
 * @date 2019/11/5
 */
public class BaseController<T> {

    protected ResponseVo<T> success(T data){
        ResponseVo<T> vo = new ResponseVo<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    protected ResponseVo<T> success(T data, String message){
        ResponseVo<T> vo = new ResponseVo<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }

    protected ResponseVo success(String message){
        ResponseVo<T> vo = new ResponseVo<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setMessage(message);
        return vo;
    }

    protected ResponseVo error(String message){
        ResponseVo vo = new ResponseVo();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(message);
        return vo;
    }
}