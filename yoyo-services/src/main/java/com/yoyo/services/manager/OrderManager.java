package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.services.entity.Order;
import java.io.IOException;
import java.util.ArrayList;

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
            String[] content = fileManager.readLine(i);
            orders.add(
                new Order(
                    Integer.parseInt(content[0]), 
                        Long.valueOf(content[1]), 
                        content[2], 
                        content[3], 
                        Double.valueOf(content[4]),
                        content[5], 
                        Boolean.parseBoolean(content[6])
                )
            );
        }
    }
    
    public ArrayList<Order> getOrders(){
      return orders;
    }
    
    public void addOrders(Order newOrders){
        orders.add(newOrders);
    }
    
    public void saveOrders() throws IOException{
        //Clear contents of bookings file before writing
        fileManager.clearFile();
        
        for (int i = 0; i < orders.size(); i++){
            
            Order order = orders.get(i); //Getting bookings instances
            String[] data = new String[7];
            
            data[0] = String.valueOf(order.getQuantity());
            data[1] = order.getItemCode().toString();
            data[2] = order.getSalesPersonName();
            data[3] = order.getCustomerName();
            data[4] = order.getTotalPrice().toString();
            data[5] = order.getCreationDate();
            data[6] = order.isStatus() == true ? "true" : "false";
            fileManager.writeFile(data, true);
        }
    }
    
    public void overwriteOrdersList(ArrayList<Order> newOrders) throws IOException{
        this.orders = newOrders;
    }
}
