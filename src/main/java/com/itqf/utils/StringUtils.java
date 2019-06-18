package com.itqf.utils;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/14
 * @Time: 下午5:16
 */
public class StringUtils {

    public  static  boolean isEmpty(String key){
        if (key==null){
            return true;
        }
        key = key.trim();
        if ("".equals(key)){
            return true;
        }

        return false;
    }

//    public  static  boolean isBlank(String key){
//
//    }
//
//    public  static  boolean isNotBlank(String key){
//
//    }

    public  static  boolean isNotEmpty(String key){
      return  !isEmpty(key);
    }

}
