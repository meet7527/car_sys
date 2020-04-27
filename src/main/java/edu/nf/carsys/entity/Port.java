package edu.nf.carsys.entity;

import lombok.Data;

/**
 * @author LWP
 * @date 2019/12/2
 */
@Data
public class Port {

    private Integer portId;
    private String  portIdentity;
    private String portNum;
    private String carId;

}