package com.cz.util;

import java.util.UUID;

public class IDGeneratorUtil {
    public static String generateID(){
        return generateID(System.currentTimeMillis());
    }
    public static String generateID(Long time){
        String rtnVal = Long.toHexString(time);
        rtnVal += UUID.randomUUID();
        rtnVal = rtnVal.replaceAll("-","");
        return rtnVal.substring(0,32);
    }
}
