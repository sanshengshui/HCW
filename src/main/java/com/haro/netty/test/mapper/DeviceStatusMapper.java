package com.haro.netty.test.mapper;

import com.haro.netty.test.pojo.DeviceStatus;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 123 on 2017/5/11.
 */
public interface DeviceStatusMapper {

    @Update(" UPDATE eqp_basicinfo\n" +
            "        SET iccid=#{iccid},\n" +
            "        status_id=#{status_id},\n" +
            "        deleted=#{deleted}" +
            "        WHERE eqp_comid=#{eqp_comid} AND status_id !=3")
    void updateIotDeviceIccid(DeviceStatus deviceBasicInfo);
}
