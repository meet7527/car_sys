package edu.nf.carsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.nf.carsys.dao")
public class CarSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSysApplication.class, args);
    }

}
