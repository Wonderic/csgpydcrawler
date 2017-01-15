package com.kit.csg.utils;

import org.springframework.util.Base64Utils;

import java.util.UUID;

/**
 * Created by furthers on 2016/8/30.
 */
public class Utils {
    public static String newUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    public static String encodeBase64(byte[] src){
        return Base64Utils.encodeToString(src);
    }
    public static byte[] decodeBase64(String src){
        return Base64Utils.decodeFromString(src);
    }
}
