package edu.nf.carsys.dao;

import edu.nf.carsys.entity.Port;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LWP
 * @date 2019/12/2
 */
public interface PortDao {

    List<Port> getPortList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    List<Port> getPortNum();
    void addPort(Port port);
    void updatePort(Port port);
    Port getPortByPort(String port);
}