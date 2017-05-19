package com.haro.netty.iot.thread;

import com.haro.netty.service.DeviceStatusService;
import com.haro.netty.service.StatusDeviceService;
import com.haro.netty.test.pojo.DeviceStatus;
import com.haro.netty.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 123 on 2017/5/19.
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
