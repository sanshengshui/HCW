package com.haro.netty.iot.staticOfFinal.proto.protocol;

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
 * + X // Body Content:为主体数据长度； data:表示主体数据；
 * + 2 // frame_tail:帧尾 ##,表示1帧数据结束；
 * jupiter
 * org.jupiter.transport
 *
 * @ClassName HProtocolHeader
 * @author 穆书伟
 * @Email lovewsic@gmail.com
 * @Description HCW传输层协议头
 * @Date 2017/7/18 17:26:21
 */
public class HProtocolHeader {
}
