/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import java.io.IOException;

/**
 *
 * @author user
 */
public class SalesManager {
    
    private static InvoiceManager invoiceManager;
     private final FileManager fileManager = new FileManager(DataConstants.INVOICE_FILE);

    public SalesManager(){

    }
    
    
    public String totalFurnitureSold(){
       int lines = fileManager.contentLength();
       return String.valueOf(lines);
    }
    
//    public String totalSalesEarned(){
//        
//    }
//    
//    public String totalCommissionEarned(){
//        
//    }
}
