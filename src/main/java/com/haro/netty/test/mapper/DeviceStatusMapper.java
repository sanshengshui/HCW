package com.haro.netty.test.mapper;

import com.haro.netty.test.pojo.DeviceStatus;
import org.apache.ibatis.annotations.Update;

/**
 * @author 穆书伟
 * @description 利用mybatis注释sql映射到数据库
 * @date 2017-5-22 17:56
 * @comment  updateIotDeviceIccid 把设备的设备通讯码保存到数据库中
 *             updateIotDeviceStatus 实时更新设备状态
 */
public interface DeviceStatusMapper {

    @Update(" UPDATE eqp_basicinfo\n" +
            "        SET iccid=#{iccid}, status_id=#{status_id} \n" +
            "     " +
            "        WHERE eqp_comid=#{eqp_comid} AND status_id !=3 AND status_id !=4")
    void updateIotDeviceIccid(DeviceStatus deviceBasicInfo);

    @Update(" UPDATE eqp_basicinfo \n" +
            "        SET status_id=5 \n" +
            "        WHERE eqp_comid=#{eqp_comid} AND status_id!=2")
    void updateIotDeviceStatus(DeviceStatus deviceStatus);
}
