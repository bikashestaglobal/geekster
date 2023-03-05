package com.geekster.chatty.utils;

import java.util.HashMap;
import java.util.Map;

public class CommonUtills {
    public static Map<Object, Object> setStatusResponse( String message, Object error){
        Map<Object, Object> reqMap = new HashMap<>();
        reqMap.put("message", message);
        reqMap.put("error", error);
//        reqMap.put("status", );
        return reqMap;
    }
}
