package com.haro.netty.util;

import java.util.zip.Inflater;

/**
 * 
* @ClassName: ByteUtil  
* @Description: TODO  Byte 数组管理
* @author 穆书伟
* @Email lovewsic@gmail.com
* @date 2017年1月18日 下午3:45:16
 */
public class ByteUtil {
	/**
	 * @Title:byteToChar
	 * @Description:TODO byte类型转换成Char
	 */
	public static void Str2Hex(char[] sSrc,byte[] sDest,int nSrcLen){
		for(int i=0;i<nSrcLen;i=i+2){
			int mu=HEX2BYTE(sSrc[i])*16+HEX2BYTE(sSrc[i+1]);
			byte sw=(byte)mu;
			sDest[i/2]=sw;

		}
	}
	/**
	 * @Title: CharToByte
	 * @Description:TODO char类型转换成Byte
	 *
	 */
	public static int HEX2BYTE(char hex_ch){

		if(hex_ch>='0'&& hex_ch <= '9')
		{

			return hex_ch-'0';

		}
		if (hex_ch >= 'a' && hex_ch <= 'f')
		{
			return hex_ch - 'a' + 10;


		}

		if (hex_ch >= 'A' && hex_ch <= 'F')
		{
			return hex_ch - 'A' + 10;
		}
		return 0x00;

	}
	
	/**
	 * 
	* @Title: ByteToInt  
	* @Description: TODO Byte 转成 Int
	* @param @param readbuf
	* @param @return    参数  
	* @return int    返回类型  
	* @throws
	 */
	public static int ByteToInt(byte[]readbuf){
		String str = "";
		for(int i = 0; i< readbuf.length ; i++){
			if(readbuf[i]==0){
				str += "00";
			}else if(readbuf[i] >= 1 && readbuf[i] <= 9){
				str +=  "0" + Byte.toString(readbuf[i]);
			}else {
				str +=Byte.toString(readbuf[i]);
			}
		}
		int s =Integer.parseInt(str);
		return s;
	}
	public static int ByteToInt(byte[]readbuf,int start,int end){
		String str = "";
		for(int i = start; i<= end ; i++){
			if(readbuf[i]==0){
				str += "00";
			}else if(readbuf[i] >= 1 && readbuf[i] <= 9){
				str +=  "0" + Byte.toString(readbuf[i]);
			}else {
				str +=Byte.toString(readbuf[i]);
			}
		}
		int s =Integer.parseInt(str);
		return s;
	}
	/**
	 *   
	* @Title: ByteToString  
	* @Description: TODO
	* @param @param readBuf
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	public static String ByteToString(byte[]readBuf){
		String str = "";
		for(int i = 0; i< readBuf.length ; i++){
			if(readBuf[i]==0){
				str += "00";
			}else if(readBuf[i] >= 1 && readBuf[i] <= 9){
				str +=  "0" + Byte.toString(readBuf[i]);
			}else {
				str +=Byte.toString(readBuf[i]);
			}
		}
		return str;
	}
	public static String ByteToString(byte[]readBuf,int start,int end){
		String str = "";
		if(start > end || start < 0 || end < 0 || start >readBuf.length || end > readBuf.length ){
			return null;
		}
		for(int i = start; i<= end ; i++){
			if(readBuf[i]==0){
				str += "00";
			}else if(readBuf[i] >= 1 && readBuf[i] <= 9){
				str +=  "0" + Byte.toString(readBuf[i]);
			}else {
				str +=Byte.toString(readBuf[i]);
			}
		}
		return str;
	}
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param src
	 *            字节数组
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
			stringBuilder.append(' ');
		}
		String str= stringBuilder.toString();
		return str.toUpperCase();
	}
}
