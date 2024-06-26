package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.services.entity.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OrderManager {
    private final FileManager fileManager = new FileManager(DataConstants.ORDER_QUOTATION_FILE);
    
    private ArrayList<Order> orders;
    private int lines;
    
    public OrderManager(){
        orders = new ArrayList<>();
    }
    
    //Outside of constructor to avoid conflict when overwriting content
    public void loadOrders() throws IOException{
        //Load Contents into array
        fileManager.readFile();
        
        lines = fileManager.contentLength();
        if (orders == null){
            orders = new ArrayList<>(lines); //Assigning capacity based on number of entries
        }
        else {
            orders.clear(); //Delete any existing contents for memory optimization
        }

        for (int i = 0; i < lines; i++){
            try {
                String[] content = fileManager.readLine(i);
                orders.add(
                    new Order(
                        Integer.parseInt(content[0]), 
                        Long.valueOf(content[1]), 
                        content[2], 
                        content[3], 
                        Double.valueOf(content[4]),
                        content[5], 
                        content[6]
                    )
                );   
            }
            // Stop operation if data error occurs
            catch (NumberFormatException e) {
                break;
            }
        }   
    }
    
    public ArrayList<Order> getOrders(){
      return orders;
    }
    
    public void addOrders(Order newOrders){
        orders.add(newOrders);
    }
    
    public void saveOrders(){
        try {
            //Clear contents of file before writing
            fileManager.clearFile();

            for (int i = 0; i < orders.size(); i++){

                Order order = orders.get(i);
                String[] data = new String[7];

                data[0] = String.valueOf(order.getQuantity());
                data[1] = order.getItemCode().toString();
                data[2] = order.getSalesPersonName();
                data[3] = order.getCustomerName();
                data[4] = order.getUnitPrice().toString();
                data[5] = order.getCreationDate();
                data[6] = order.getStatus();
                fileManager.writeFile(data, true);
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void overwriteOrdersList(ArrayList<Order> newOrders) throws IOException{
        this.orders = newOrders;
    }
    
}
