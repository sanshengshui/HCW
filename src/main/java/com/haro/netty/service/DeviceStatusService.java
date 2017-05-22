package com.haro.netty.service;

import com.haro.netty.test.pojo.DeviceStatus;

/**
 * @author 穆书伟
 * @descriptin 服务接口Service
 * @date 2017/5/22 18:37
 */
public interface DeviceStatusService {
    void updateIotDeviceIccid(DeviceStatus deviceBasicInfo);


}
