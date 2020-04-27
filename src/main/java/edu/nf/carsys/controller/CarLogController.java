package edu.nf.carsys.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.entity.CarLog;
import edu.nf.carsys.service.CarLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LWP
 * @date 2019/11/26
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class CarLogController extends BaseController {

    @Autowired
    private CarLogService service;

    @PostMapping("get_carPortList")
    public ResponseVo getCarportList(Integer pageNum,Integer pageSize,String userName){
        PageInfo<CarLog> pageInfo = service.getCarportList(pageNum,pageSize,userName);
        return success(pageInfo);
    }

    @PostMapping("deleteCarport")
    public ResponseVo deleteCarport(Integer[] id){
        service.deleteCarport(id);
        return success("删除成功");
    }

}