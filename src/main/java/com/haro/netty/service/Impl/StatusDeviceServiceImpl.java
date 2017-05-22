package com.haro.netty.service.Impl;

import com.haro.netty.service.StatusDeviceService;
import com.haro.netty.test.mapper.DeviceStatusMapper;
import com.haro.netty.test.pojo.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 穆书伟
 * @descriptin 服务接口实现类Impl
 * @date 2017/5/22 18:37
 */
@Service("deviceDeviceStatus")
@Transactional
public class StatusDeviceServiceImpl implements StatusDeviceService {
    @Autowired
    private DeviceStatusMapper deviceStatusMapper;

    public void setDeviceStatusMapper(DeviceStatusMapper deviceStatusMapper) {
        this.deviceStatusMapper = deviceStatusMapper;
    }

    public void updateIotDeviceStatus(DeviceStatus deviceStatus) {
        deviceStatusMapper.updateIotDeviceStatus(deviceStatus);

    }
}
