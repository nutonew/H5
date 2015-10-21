package com.nut.one.comm.utils;

/**
 * Created by dolphin on 2015/10/21.
 */
public class StringUtils {

    public static String[] getRegStringArray(String source,String reg,String delimater){
        String arrStr = source.substring(source.indexOf("\""),source.lastIndexOf("\""));
        return arrStr.split(delimater,-1);
    }

}
