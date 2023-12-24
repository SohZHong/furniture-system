package com.yoyo.common.constant;

import java.io.File;

public class DataConstants {
    //double backquote to prevent compiler interpreting words as special characters, eg. \n
    public static final String DATA_FOLDER = new File("resources\\data\\").getAbsolutePath();
}
