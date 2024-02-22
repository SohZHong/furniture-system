package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.common.constant.StatusConstants;
import com.yoyo.common.utils.IdUtils;
import com.yoyo.services.entity.Invoice;
import com.yoyo.services.entity.Order;
import com.yoyo.services.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceManager {
    private final FileManager fileManager = new FileManager(DataConstants.INVOICE_FILE);
    
    private ArrayList<Invoice> invoices;
    private int lines;
    
    public InvoiceManager(){
        invoices = new ArrayList<>();
    }
    
    //Outside of constructor to avoid conflict when overwriting content
    public void loadInvoices() throws IOException{
        //Load Contents into array
        fileManager.readFile();
        
        lines = fileManager.contentLength();
        if (invoices == null){
            invoices = new ArrayList<>(lines); //Assigning capacity based on number of entries
        }
        else {
            invoices.clear(); //Delete any existing contents for memory optimization
        }
        for (int i = 0; i < lines; i++){
            try {
                String[] content = fileManager.readLine(i);
                invoices.add(
                    new Invoice(
                        content[0], 
                        Double.valueOf(content[1]), 
                        content[2],
                        content[3],
                        content[4]
                    )
                );   
            }
            // Stop operation if data error occurs
            catch (Exception e) {
                break;
            }
        }   
    }
    
    public ArrayList<Invoice> getInvoices(){
      return invoices;
    }
    
    public void addInvoice(Invoice newInvoice){
        invoices.add(newInvoice);
    }
    
    public void generateInvoices(ArrayList<Order> orders) throws IOException{
        loadInvoices();
        for (Order order: orders){
            if (order.getStatus().equals(StatusConstants.ACCEPTED_ORDER)){
                // Generate a new invoice with uuid
                Invoice newInvoice = new Invoice(
                    IdUtils.simpleUUID(),
                    order.getTotalPrice(),
                    order.getSalesPersonName(),
                    order.getCustomerName()
                );
                // Add it into the list
                addInvoice(newInvoice);
            }
            else {
                throw new RuntimeException("Selected Order has not been accepted");
            }
        }
        saveInvoices();

    }
    
    public void saveInvoices(){
        try {
            fileManager.clearFile();

            for (int i = 0; i < invoices.size(); i++){
                Invoice invoice = invoices.get(i);
                String[] data = new String[5];

                data[0] = invoice.getInvoiceNo();
                data[1] = invoice.getTotalPrice().toString();
                data[2] = invoice.getSalesPersonName();
                data[3] = invoice.getCustomerName();
                data[4] = invoice.getStatus();
                fileManager.writeFile(data, true);
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void overwriteInvoicesList(ArrayList<Invoice> newInvoices) throws IOException{
        this.invoices = newInvoices;
    }
    
     public Object[] totalSalesforSalesPerson(){
       int count = 0;
       int sales = 0;
       int commission = 0;
       User loginUser = ApplicationContext.getLoginUser();
       String username = loginUser.getName();
       for(Invoice invoice: invoices){
           if(username.equals(invoice.getSalesPersonName()) && invoice.getStatus().equals(StatusConstants.INVOICE_WORK_DONE)){
               count += 1;
               sales += invoice.getTotalPrice();
               commission += invoice.getTotalPrice() * 0.2;
           }
       }
       
       Object [] result = new Object[3];
       result[0] = String.valueOf(count);
       result[1] = String.valueOf(sales);
       result[2] = String.valueOf(commission);
       return result;
    }

}
