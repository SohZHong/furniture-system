package com.yoyo.system.model;

import com.yoyo.services.entity.Order;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class SalesPersonOrderTableModel extends AbstractTableModel{

    private final ArrayList<Order> orders;
    private ArrayList<Order> filteredOrders;
    private Order order;
    
    private final boolean[] canEdit = new boolean[]{
            true, true, true, false, false, false
    };
    
    public SalesPersonOrderTableModel(ArrayList<Order> orders) {
        this.orders = orders;
        this.filteredOrders = new ArrayList<>(orders);
    }
    
    @Override
    public int getRowCount() {
        return filteredOrders.size();
    }

    @Override
    public int getColumnCount() {
        // Quantity, Item Code, Customer Name, Total Price, Creation Date, Status
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: return JComboBox.class;
            case 2: return String.class;
            case 3: return Double.class;
            case 4: return String.class;
            case 5: return Boolean.class;
                
        }
        return Object.class;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "Quantity";
            case 1: return "Item Code";
            case 2: return "Customer Name";
            case 3: return "Total Price";
            case 4: return "Creation Date";
            case 5: return "Status";
        }
        return null;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        order = filteredOrders.get(rowIndex);
        switch (columnIndex){
            case 0: return order.getQuantity();
            case 1: return order.getItemCode();
            case 2: return order.getCustomerName();
            case 3: return order.getTotalPrice();
            case 4: return order.getCreationDate();
            case 5: return order.isStatus();
        }
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        order = filteredOrders.get(rowIndex);
        switch (columnIndex){
            case 0: 
                order.setQuantity((Integer) value);
                break;
            case 1: 
                order.setItemCode((Long) value);
                break;
            case 2: 
                order.setCustomerName((String) value);
                break;
            case 3: 
                order.setTotalPrice((Double) value);
                break;
            case 4:
                order.setCreationDate((String) value);
                break;
            case 5:
                order.setStatus((Boolean) value);
                break;
        }
        
        // Now, find the corresponding order in the original 'orders' list and update it
        for (Order originalOrder : orders) {
            if (originalOrder.equals(order)) {
                originalOrder.copyFrom(order);
                break;
            }
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void setFilter(String searchString, int columnIndex) {
        String query;
        filteredOrders.clear();
        
        // Perform search based on column
        for (Order order : orders) {
            query = switch (columnIndex) {
                case 0 -> String.valueOf(order.getQuantity());
                case 1 -> String.valueOf(order.getItemCode());
                case 2 -> order.getCustomerName();
                case 3 -> String.valueOf(order.getTotalPrice());
                case 4 -> order.getCreationDate();
                case 5 -> order.isStatus() ? "true" : "false";
                default -> null;
            };
            if (query!= null && query.toLowerCase().contains(searchString.toLowerCase())) {
                filteredOrders.add(order);
            }
        }

        fireTableDataChanged(); // Notify the table that the data has changed
    }

    public String[] getColumnNames() {
        return new String[]{"Quantity", "Item Code", "Customer Name", "Total Price", "Creation Date", "Status"};
    }

    public int[] getColumnIndices() {
        return new int[]{0, 1, 2, 3, 4, 5};
    }
    
    public void deleteRow(int rowIndex) {
        filteredOrders.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
