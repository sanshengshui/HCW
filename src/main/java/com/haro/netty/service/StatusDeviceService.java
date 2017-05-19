package com.haro.netty.service;

import com.haro.netty.test.pojo.DeviceStatus;

/**
 * Created by 123 on 2017/5/19.
 */
public interface StatusDeviceService {
    void updateIotDeviceStatus(DeviceStatus deviceStatus);
}
