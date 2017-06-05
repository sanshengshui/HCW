package com.haro.netty.iot.staticOfFinal.proto.common.bean;

/**
 * @author 穆书伟
 * @description 封装RPC响应
 * @date 2017/6/5 17:33
 */
public class RpcResponse {
    //帧头
    private String frame_head;
    //方向
    private String Dir;
    //身份码
    private String CommunicationID;
    //SIM卡编码
    private String SIMCCID;
    //产品码
    private String Produc;
    //功能码
    private String comm;
    //数据长度
    private String data_length;
    //数据
    private String data;
    //帧尾
    private String frame_tail;

    public String getFrame_head() {
        return frame_head;
    }

    public void setFrame_head(String frame_head) {
        this.frame_head = frame_head;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String dir) {
        Dir = dir;
    }

    public String getCommunicationID() {
        return CommunicationID;
    }

    public void setCommunicationID(String communicationID) {
        CommunicationID = communicationID;
    }

    public String getSIMCCID() {
        return SIMCCID;
    }

    public void setSIMCCID(String SIMCCID) {
        this.SIMCCID = SIMCCID;
    }

    public String getProduc() {
        return Produc;
    }

    public void setProduc(String produc) {
        Produc = produc;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getData_length() {
        return data_length;
    }

    public void setData_length(String data_length) {
        this.data_length = data_length;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFrame_tail() {
        return frame_tail;
    }

    public void setFrame_tail(String frame_tail) {
        this.frame_tail = frame_tail;
    }
}
