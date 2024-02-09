package com.yoyo.common.constant;

public class FilterConstants {
    // No special characters and digits
    public static String USERNAME_REGEX = "^[a-zA-Z]{1,}$";
    // 6 characters and above
    public static String PASSWORD_REGEX = ".{6,}";
    // Malaysian phone number format
    public static String PHONE_NUMBER_REGEX = "^60?(?:01[02346-9]\\d{7}|011\\d{8}|015\\d{8})$";
}
