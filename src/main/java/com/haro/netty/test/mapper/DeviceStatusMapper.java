package com.haro.netty.test.mapper;

import com.haro.netty.test.pojo.DeviceStatus;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 123 on 2017/5/11.
 */
public interface DeviceStatusMapper {

    @Select(" UPDATE eqp_basicinfo\n" +
            "        SET iccid=#{iccid},\n" +
            "        status_id=#{status_id}" +
            "        WHERE eqp_comid=#{eqp_comid}")
    void updateIotDeviceIccid(DeviceStatus deviceBasicInfo);
}
