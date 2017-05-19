package com.haro.netty.test.mapper;

import com.haro.netty.test.pojo.DeviceStatus;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 123 on 2017/5/11.
 */
public interface DeviceStatusMapper {

    @Update(" UPDATE eqp_basicinfo\n" +
            "        SET iccid=#{iccid}, status_id=#{status_id} \n" +
            "     " +
            "        WHERE eqp_comid=#{eqp_comid} AND status_id !=3")
    void updateIotDeviceIccid(DeviceStatus deviceBasicInfo);

    @Update(" UPDATE eqp_basicinfo \n" +
            "        SET status_id=5 \n" +
            "        WHERE eqp_comid=#{eqp_comid} AND status_id!=2")
    void updateIotDeviceStatus(DeviceStatus deviceStatus);
}
