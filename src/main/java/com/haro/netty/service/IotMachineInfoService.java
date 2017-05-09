package com.haro.netty.service;

import com.haro.netty.test.pojo.DeviceStatus;

/**
 * @author 穆书伟
 * @description TODO updateIotMachineInfo
 * @date 2017/5/9   9:17
 */
public interface IotMachineInfoService {
     DeviceStatus updateIotMachineInfo(String eqp_comid);
}
