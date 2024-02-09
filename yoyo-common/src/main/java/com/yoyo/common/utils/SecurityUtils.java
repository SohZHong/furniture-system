/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoyo.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author user
 */
public class SecurityUtils {
    
    public static String encodeAESAndBase64Format(String value, String secretKey) throws Exception{
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
        String encodedValue = Base64.getEncoder().encodeToString(encryptedBytes);
        return encodedValue;
    }
    
    public static String decodeAESAndBase64Format(String encodedValue, String secretKey) throws Exception{
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] encryptedBytes = Base64.getDecoder().decode(encodedValue);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decodedToken = new String(decryptedBytes, StandardCharsets.UTF_8);

        return decodedToken; 
    }
}
