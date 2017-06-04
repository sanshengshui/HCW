package com.haro.netty.iot.staticOfFinal.proto.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 穆书伟
 * @description 字符串工具类
 * @date 2017/6/5 0:04
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if(str !=null){
            str=str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 分割固定格式的字符串
     */
    public static String[] split(String str,String separator){
        return StringUtils.splitByWholeSeparator(str,separator);
    }
}
