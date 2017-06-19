package com.haro.netty.service;

/**
 * @ClassName QueryStatusForLightService
 * @author 穆书伟
 * @description 设备状态灯变化接口
 * @date 2017/6/19 12:43
 */
public interface QueryStatusForLightService {
    int SendCommandForLight(String eqp_comid);
}
