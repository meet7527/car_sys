package edu.nf.carsys.controller.vo;

/**
 * @author LWP
 * @date 2019/11/5
 */
public class ResponseVo<T> {

    private Integer code;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    private Object message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}