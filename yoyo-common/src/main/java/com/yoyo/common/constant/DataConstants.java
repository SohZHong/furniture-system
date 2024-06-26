package com.yoyo.common.constant;

import java.io.File;

public class DataConstants {
    //double backquote to prevent compiler interpreting words as special characters, eg. \n
    public static final String DATA_FOLDER = new File("src\\main\\resources\\data\\").getAbsolutePath();
    
    public static final String ASSET_FOLDER = new File("src\\main\\resources\\").getAbsolutePath();
    
    public static final String FURNITURE_FILE = "IKEA_SA_Furniture_Web_Scrapings_sss.csv";
    
    public static final String ORDER_QUOTATION_FILE = "orders";
    
    public static final String USER_CREDENTIAL_FILE = "users";

    public static final String INVOICE_FILE = "invoices";

}
