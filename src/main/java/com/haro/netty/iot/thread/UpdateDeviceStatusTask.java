package com.haro.netty.iot.thread;

import com.haro.netty.service.DeviceStatusService;
import com.haro.netty.service.StatusDeviceService;
import com.haro.netty.test.pojo.DeviceStatus;
import com.haro.netty.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 穆书伟
 * @description 更新设备状态
 * @date 2017/5/22 18:39
 */
public class UpdateDeviceStatusTask implements Runnable {
    private static final Logger logger= LoggerFactory.getLogger(UpdateDeviceStatusTask.class);

    private String deviceComid;

    public UpdateDeviceStatusTask(String deviceComid){
        this.deviceComid=deviceComid;

    }
    public void run() {
        DeviceStatus deviceStatus=new DeviceStatus();

        try{
            deviceStatus.setEqp_comid(deviceComid);

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        StatusDeviceService statusDeviceService =(StatusDeviceService) SpringUtil.getApplicationContext().getBean("deviceDeviceStatus");
        statusDeviceService.updateIotDeviceStatus(deviceStatus);
    }
}
