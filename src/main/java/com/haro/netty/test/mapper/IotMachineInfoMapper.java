package com.haro.netty.test.mapper;

import com.haro.netty.test.pojo.DeviceStatus;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 123 on 2017/5/9.
 */
public interface IotMachineInfoMapper {

    @Update("UPDATE eqp_basicinfo \n" +
            "SET status_id= 2 WHERE eqp_comid=#{eqp_comid}")
    DeviceStatus updateIotMachineInfo(String eqp_comid);

}
