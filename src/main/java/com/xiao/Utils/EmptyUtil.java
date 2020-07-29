package com.xiao.Utils;

public class EmptyUtil {

    public static void isEmpty(String str,String strName){
        if (str == null){
            throw new IllegalArgumentException(strName+"不能为空！");
        }else if (str.equals(""))
            throw new IllegalArgumentException(strName+"不能为空字符串！");
    }

}
