package com.haro.netty.iot.thread;

import com.haro.netty.service.QueryStatusForLightService;
import com.haro.netty.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName SendCommandForLightTask
 * @author 穆书伟
 * @description 根据数据库发送灯变化指令
 * @date 2017/6/19 12:46
 */
public class SendCommandForLightTask implements Runnable {
    private static final Logger logger= LoggerFactory.getLogger(SendCommandForLightTask.class);
    private String deviceComid;

    public SendCommandForLightTask(String deviceComid){
        this.deviceComid=deviceComid;

    }

    public void run() {

        QueryStatusForLightService queryStatusForLightService = (QueryStatusForLightService) SpringUtil.getApplicationContext().getBean("deviceDeviceForLight");
        queryStatusForLightService.SendCommandForLight(deviceComid);

    }
}
