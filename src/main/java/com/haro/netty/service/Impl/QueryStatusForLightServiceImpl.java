package com.haro.netty.service.Impl;

import com.haro.netty.service.QueryStatusForLightService;
import com.haro.netty.test.mapper.DeviceStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName QueryStatusForLightServiceImpl
 * @author 穆书伟
 * @description 设备状态灯变化实现类
 * @date 2017/6/19 12:44
 */
@Service("deviceDeviceForLight")
@Transactional
public class QueryStatusForLightServiceImpl implements QueryStatusForLightService{
    @Autowired
    private DeviceStatusMapper deviceStatusMapper;

    public void setDeviceStatusMapper(DeviceStatusMapper deviceStatusMapper) {
        this.deviceStatusMapper = deviceStatusMapper;
    }

    public int SendCommandForLight(String eqp_comid) {
        return deviceStatusMapper.SendCommandForLight(eqp_comid);
    }
}
