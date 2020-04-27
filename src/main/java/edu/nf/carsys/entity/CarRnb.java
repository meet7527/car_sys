package edu.nf.carsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/11/25
 */
@Data
public class CarRnb {

    private Integer id;
    private String phoneNum;
    private String userName;
    private double money;
    private String car_id;
    private String car_vip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp stopTime;

}