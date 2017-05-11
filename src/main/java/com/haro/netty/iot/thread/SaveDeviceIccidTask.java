package com.haro.netty.iot.thread;


import com.haro.netty.service.DeviceStatusService;
import com.haro.netty.test.pojo.DeviceStatus;
import com.haro.netty.util.ByteUtil;
import com.haro.netty.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.haro.netty.util.ByteUtil.bytesToHexString;

/**
 * Created by 123 on 2017/5/11.
 */
public class SaveDeviceIccidTask implements Runnable{

    private static final Logger logger= LoggerFactory.getLogger(SaveDeviceIccidTask.class);

    private byte[] readbuf;

    private String deviceIccid;

    public SaveDeviceIccidTask(byte[] readbuf){
        this.readbuf=readbuf;
    }

    public SaveDeviceIccidTask(byte[] readbuf,String deviceIccid){
        this.readbuf=readbuf;
        this.deviceIccid=deviceIccid;
    }

    public void run() {
        DeviceStatus deviceBasicInfo=new DeviceStatus();
        /**
         * Iccid
         */
        byte[] reqDataComid=new byte[13];
        System.arraycopy(readbuf,5,reqDataComid,0,13);
        String strReqDataComid=bytesToHexString(reqDataComid).replaceAll(" ","");
        deviceBasicInfo.setEqp_comid(strReqDataComid);
        byte[] reqDataIccid=new byte[20];
        System.arraycopy(readbuf,18,reqDataIccid,0,20);
        String  strReqDataIccid=bytesToHexString(reqDataIccid).replaceAll(" ","").replaceAll("3","");
        deviceBasicInfo.setIccid(strReqDataIccid);


        DeviceStatusService deviceStatusService =(DeviceStatusService) SpringUtil.getApplicationContext().getBean("deviceDeviceIccid");
        deviceStatusService.updateIotDeviceIccid(deviceBasicInfo);
    }

}
