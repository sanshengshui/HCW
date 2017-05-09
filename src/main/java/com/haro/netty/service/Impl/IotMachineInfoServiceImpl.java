package com.haro.netty.service.Impl;

import com.haro.netty.service.IotMachineInfoService;
import com.haro.netty.test.mapper.IotMachineInfoMapper;
import com.haro.netty.test.pojo.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 穆书伟
 * @description 更新机器状态的继承类
 * @date 2017/5/9 09:24
 */
@Service
@Transactional
public class IotMachineInfoServiceImpl implements IotMachineInfoService {
    private IotMachineInfoMapper iotMachineInfoMapper;

    @Autowired
    public void setIotMachineInfoMapper(IotMachineInfoMapper iotMachineInfoMapper) {
        this.iotMachineInfoMapper = iotMachineInfoMapper;
    }

    public DeviceStatus updateIotMachineInfo(String eqp_comid) {
        return iotMachineInfoMapper.updateIotMachineInfo(eqp_comid);
    }
}
