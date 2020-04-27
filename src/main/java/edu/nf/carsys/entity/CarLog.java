package edu.nf.carsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/11/26
 */
@Data
public class CarLog {

    private Integer id;
    private String logType;
    private String area;
    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp logTime;


}
