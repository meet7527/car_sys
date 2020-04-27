package edu.nf.carsys.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.entity.CarUser;
import edu.nf.carsys.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author LWP
 * @date 2019/11/19
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class CarUserController extends BaseController {

    @Autowired
    private CarService service;

    @PostMapping("get_list")
    public ResponseVo getCarList(Integer pageNum,Integer pageSize){
        PageInfo<CarUser> list = service.getCarUserLi(pageNum,pageSize);
        return success(list);
    }

    @PostMapping("delete")
    public ResponseVo delete(String []id,String port, HttpSession session){
        service.deleteUser(id,port,session);
        return success("删除成功");
    }

    @PostMapping("insert")
    public ResponseVo insert(@Valid CarUser carUser, HttpSession session){

        service.addUser(carUser,session);
        return success("添加成功");
    }

    @PostMapping("selectById")
    public ResponseVo selectById(String id){
        CarUser carUser = service.getUserById(id);
        return success(carUser);
    }

    @PostMapping("update_carUser")
    public ResponseVo update(CarUser carUser, HttpSession session){
        service.update(carUser,session);
        return success("修改成功");
    }

    @PostMapping("get_vip")
    public ResponseVo getCarVip(Integer pageNum,Integer pageSize){
        PageInfo<CarUser> list = service.getCarVip(pageNum,pageSize);
        return success(list);
    }

    @PostMapping("get_rmb")
    public ResponseVo getRmb(CarUser carUser, HttpSession session){
        double d = service.getRmb(carUser,session);
        return success(d,"结算成功");
    }
}