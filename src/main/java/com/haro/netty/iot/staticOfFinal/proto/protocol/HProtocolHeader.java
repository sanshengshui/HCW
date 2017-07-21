package com.haro.netty.iot.staticOfFinal.proto.protocol;

import java.util.Arrays;

/**
 * HCW传输层协议头
 *
 * **************************************************************************************************
 *                                          Protocol
 *  ┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐
 *       4        │   1   │    13           │     20    │      1   │   1    │      2      │                      │   2
 *  ├ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┤
 *                │       │                 │           │          │        │             │                      │
 *  │frame_head      Dir     CommunicationID     SIMCCID      Produc      Comm      data_length        Body Content         frame_tail
 *                │       │                 │           │          │        │             │                      │
 *  └ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘
 *
 * 消息头42个字节定长
 * = 4 // frame_head:‘_YD_’. 签名用以验证传输数据为亚都服务器端和数据数据传输模块间的数据传递。
 * + 1 // Dir :数据方向，0x01代表设备至服务器，0x02表示服务器至设备；
 * + 13// CommunicationID:设备通信识别码。通信编码用以表征数据传输模块的身份；
 * + 20 // SIMCCID:SIM卡的CCID号，20个字节，16进制ASCII码形式；
 * + 1 // Produc:产品码
 * + 1 // Comm:命令码
 * + 2 // data_length:消息体 body 长度, int 类型
 * --- 以上数据帧总和为42个字节 ---
 * + X // Body Content:为主体数据长度； data:表示主体数据；
 * + 2 // frame_tail:帧尾 ##,表示1帧数据结束；
 * jupiter
 *
 * org.jupiter.transport
 *
 * @ClassName HProtocolHeader
 * @author 穆书伟
 * @Email lovewsic@gmail.com
 * @Description HCW传输层协议头
 * @Date 2017/7/18 17:26:21
 */
public class HProtocolHeader {

    /**
     * 数据组帧如下
     */

    private byte[] FH;
    private byte dir;
    private byte[] communicID;
    private byte[] simCcid;
    private byte produc;
    private byte comm;
    private byte[] data_length;
    private byte[] data;
    private byte[] frame_tail;

    public byte[] getFH() {
        return FH;
    }

    public void setFH(byte[] FH) {
        this.FH = FH;
    }

    public byte getDir() {
        return dir;
    }

    public void setDir(byte dir) {
        this.dir = dir;
    }

    public byte[] getCommunicID() {
        return communicID;
    }

    public void setCommunicID(byte[] communicID) {
        this.communicID = communicID;
    }

    public byte[] getSimCcid() {
        return simCcid;
    }

    public void setSimCcid(byte[] simCcid) {
        this.simCcid = simCcid;
    }

    public byte getProduc() {
        return produc;
    }

    public void setProduc(byte produc) {
        this.produc = produc;
    }

    public byte getComm() {
        return comm;
    }

    public void setComm(byte comm) {
        this.comm = comm;
    }

    public byte[] getData_length() {
        return data_length;
    }

    public void setData_length(byte[] data_length) {
        this.data_length = data_length;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getFrame_tail() {
        return frame_tail;
    }

    public void setFrame_tail(byte[] frame_tail) {
        this.frame_tail = frame_tail;
    }

    @Override
    public String toString() {
        return "HProtocolHeader{" +
                "FH=" + Arrays.toString(FH) +
                ", dir=" + dir +
                ", communicID=" + Arrays.toString(communicID) +
                ", simCcid=" + Arrays.toString(simCcid) +
                ", produc=" + produc +
                ", comm=" + comm +
                ", data_length=" + Arrays.toString(data_length) +
                ", data=" + Arrays.toString(data) +
                ", frame_tail=" + Arrays.toString(frame_tail) +
                '}';
    }
}
