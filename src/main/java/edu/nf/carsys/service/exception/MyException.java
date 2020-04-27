package edu.nf.carsys.service.exception;

/**
 * @author LWP
 * @date 2019/11/7
 */
public class MyException extends RuntimeException {


    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}