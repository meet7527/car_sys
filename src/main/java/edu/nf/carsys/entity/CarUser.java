package edu.nf.carsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/10/27
 */
@Data
public class CarUser {

    @NotEmpty(message = "{carUser.empty}")
    private String carId;
    @NotEmpty(message = "{carUser.empty}")
    private String userName;
    @NotEmpty(message = "{carUser.empty}")
    private String userTel;
    @NotEmpty(message = "{carUser.empty}")
    private String userCard;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp stopTime;
    @NotEmpty(message = "{carUser.empty}")
    private String carVip;
    private String portNum;

}