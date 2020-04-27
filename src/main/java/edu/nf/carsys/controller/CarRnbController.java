package edu.nf.carsys.controller;

import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.service.CarRnbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LWP
 * @date 2019/11/25
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class CarRnbController<T> extends BaseController {

    @Autowired
    private CarRnbService service;

    @PostMapping("get_carCode")
    public ResponseVo<T> getCarCodeList(Integer pageNum,Integer pageSize){
        return success(service.getList(pageNum,pageSize));
    }

    @PostMapping("get_carCodeByName")
    public ResponseVo getCarCodeByName(String carId){
        return success(service.getCarCodeByName(carId));
    }
}