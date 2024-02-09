/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoyo.common.utils;

import java.util.Base64;

/**
 *
 * @author user
 */
public class SecurityUtils {
    
    public static String encodeBase64Format(String value){
        String encodedValue = Base64.getEncoder().encodeToString(value.getBytes());
        return encodedValue;
    }
    
    public static String decodeBase64Format(String encodedValue){
        String actualByte = new String(Base64.getDecoder().decode(encodedValue.getBytes()));
        return String.valueOf(actualByte);
    }
}
