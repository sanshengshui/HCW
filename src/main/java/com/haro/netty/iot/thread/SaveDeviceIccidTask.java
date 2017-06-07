package com.haro.netty.iot.thread;


import com.haro.netty.iot.staticOfFinal.proto.common.util.StringUtil;
import com.haro.netty.service.DeviceStatusService;
import com.haro.netty.test.pojo.DeviceStatus;
import com.haro.netty.util.ByteUtil;
import com.haro.netty.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.haro.netty.util.ByteUtil.bytesToHexString;

/**
 * @author 穆书伟
 * @descriptin 更新设备状态
 * @date 2017/5/22 18:40
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

        try{

            /**
             * Iccid
             */
            byte[] reqDataComid=new byte[13];
            System.arraycopy(readbuf,5,reqDataComid,0,13);
            String strReqDataComid=bytesToHexString(reqDataComid).replaceAll(" ","");
            deviceBasicInfo.setEqp_comid(strReqDataComid);
            byte[] reqDataIccid=new byte[20];
            System.arraycopy(readbuf,18,reqDataIccid,0,20);
            String  strReqDataIccid= StringUtil.queryEven(bytesToHexString(reqDataIccid).replaceAll(" ",""));
            deviceBasicInfo.setIccid(strReqDataIccid);
            //==============更新设备状态=====================
			 if((readbuf[42]&0x30)==0x00){
                
                deviceBasicInfo.setStatus_id(1);
            }else if ((readbuf[42]&0x30)==0x30){
                
                deviceBasicInfo.setStatus_id(2);
            }else {
                
                deviceBasicInfo.setStatus_id(1);
            }
			 
            
            


        }catch (Exception e){
            logger.error(e.getMessage());
        }


        DeviceStatusService deviceStatusService =(DeviceStatusService) SpringUtil.getApplicationContext().getBean("deviceDeviceIccid");
        deviceStatusService.updateIotDeviceIccid(deviceBasicInfo);
    }

}
