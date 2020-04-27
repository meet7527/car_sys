package edu.nf.carsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/12/3
 */
@Data
public class Order {

    private Integer orderId;
    private String orderUserName;
    private String orderPhoneNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp orderTime;
    private String portNum;


}