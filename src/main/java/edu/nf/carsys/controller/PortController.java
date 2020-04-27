package edu.nf.carsys.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.controller.vo.ResponseVo;
import edu.nf.carsys.entity.Port;
import edu.nf.carsys.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LWP
 * @date 2019/12/2
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST})
public class PortController extends BaseController {

    @Autowired
    private PortService portService;

    @PostMapping("get_port")
    public ResponseVo getListPort(Integer pageNum,Integer pageSize){
        PageInfo<Port> portPageInfo = portService.getListPort(pageNum,pageSize);
        return success(portPageInfo);
    }

    @PostMapping("get_portNum")
    public ResponseVo getPortNum(){
        return success(portService.getPortNum());
    }

    @PostMapping("update_port")
    public ResponseVo updatePort(String port){
        Port p = new Port();
        p.setPortIdentity("空");
        p.setPortNum(port);
        p.setCarId("没有");
        portService.updatePort(p);
        return success("成功");
    }

    @PostMapping("get_portByPort")
    public ResponseVo getPortByPort(String port){
        return success(portService.getPortByPort(port));
    }
}