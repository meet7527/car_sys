package edu.nf.carsys.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.dao.PortDao;
import edu.nf.carsys.entity.Port;
import edu.nf.carsys.service.PortService;
import edu.nf.carsys.service.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LWP
 * @date 2019/12/2
 */
@Service
public class PortServiceImpl implements PortService {

    @Autowired
    private PortDao dao;

    @Override
    public PageInfo<Port> getListPort(Integer pageNum, Integer pageSize) {
        try{
            List<Port> list = dao.getPortList(pageNum,pageSize);
            PageInfo<Port> portPageInfo = new PageInfo<>(list);
            return portPageInfo;
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }

    @Override
    public List<Port> getPortNum() {
        return dao.getPortNum();
    }

    @Override
    public void updatePort(Port port) {
        dao.updatePort(port);
    }

    @Override
    public Port getPortByPort(String port) {
        try{
            return dao.getPortByPort(port);
        }catch(Exception e){
            throw new MyException("服务器异常");
        }
    }
}