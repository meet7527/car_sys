package edu.nf.carsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

/**
 * @author LWP
 * @date 2019/11/20
 */
@Data
public class Employees {

    private Integer employId;
    @NotEmpty(message = "{employees.empty}")
    private String employName;
    @NotEmpty(message = "{employees.empty}")
    private String employCard;
    @NotEmpty(message = "{employees.empty}")
    private String posid;
    @NotEmpty(message = "{employees.empty}")
    private String employPhone;
    @NotEmpty(message = "{employees.empty}")
    private String employMali;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp employTime;
    private String pass;

}