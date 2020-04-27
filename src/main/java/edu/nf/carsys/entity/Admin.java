package edu.nf.carsys.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author LWP
 * @date 2019/11/7
 */
@Data
public class Admin {

    private int id;
    @NotEmpty(message = "{admin.userName.empty}")
    private String userName;
    @NotEmpty(message = "{admin.pass.empty}")
    private String pass;
    private String identity;

}