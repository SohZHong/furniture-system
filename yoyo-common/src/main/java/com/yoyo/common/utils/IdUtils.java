package com.yoyo.common.utils;

public class IdUtils {
    /**
     * Random UUID
     * 
     * @return Random UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * UUID without "-"
     * 
     * @return returns a simplified UUID without "-"
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }
}

