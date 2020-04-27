package edu.nf.carsys.service;

import com.github.pagehelper.PageInfo;
import edu.nf.carsys.entity.Port;

import java.util.List;

/**
 * @author LWP
 * @date 2019/12/2
 */
public interface PortService {
    PageInfo<Port> getListPort(Integer pageNum, Integer pageSize);
    List<Port> getPortNum();
    void updatePort(Port port);
    Port getPortByPort(String port);
}