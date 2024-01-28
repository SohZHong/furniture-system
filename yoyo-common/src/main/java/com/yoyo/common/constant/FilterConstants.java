package com.yoyo.common.constant;

public class FilterConstants {
    // No special characters and digits
    public static String USERNAME_REGEX = "^[a-zA-Z]{1,}$";
    // 6 characters and above
    public static String PASSWORD_REGEX = ".{6,}";
    // Malaysian phone number format
    public static String PHONE_NUMBER_REGEX = "^(60(?!0)\\d{9,10})$";
}
