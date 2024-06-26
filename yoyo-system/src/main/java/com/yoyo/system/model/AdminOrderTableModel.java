package com.yoyo.system.model;

import com.yoyo.services.entity.Order;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AdminOrderTableModel extends AbstractTableModel implements CustomTableModel{
    private final ArrayList<Order> orders;
    private final ArrayList<Order> filteredOrders;
    private Order order;
    
    private final boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false, false
    };
    
    public AdminOrderTableModel(ArrayList<Order> orders) {
        this.orders = orders;
        this.filteredOrders = new ArrayList<>(orders);
    }
    
    @Override
    public int getRowCount() {
        return filteredOrders.size();
    }

    @Override
    public int getColumnCount() {
        // Quantity, Item Code, SalesPerson, Unit Price, Total Price, Creation Date, Status
        return 7;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: return Long.class;
            case 2: return String.class;
            case 3: return Double.class;
            case 4: return Double.class;
            case 5: return String.class;
            case 6: return String.class;
        }
        return Object.class;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "Quantity";
            case 1: return "Item Code";
            case 2: return "SalesPerson";
            case 3: return "Unit Price";
            case 4: return "Total Price";
            case 5: return "Creation Date";
            case 6: return "Status";
        }
        return null;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        order = filteredOrders.get(rowIndex);
        switch (columnIndex){
            case 0: return order.getQuantity();
            case 1: return order.getItemCode();
            case 2: return order.getSalesPersonName();
            case 3: return order.getUnitPrice();
            case 4: return order.getQuantity() * order.getUnitPrice();
            case 5: return order.getCreationDate();
            case 6: return order.getStatus();
        }
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

    @Override
    public void setFilter(String searchString, int columnIndex) {
        String query;
        filteredOrders.clear();
        
        // Perform search based on column
        for (Order order : orders) {
            query = switch (columnIndex) {
                case 0 -> String.valueOf(order.getQuantity());
                case 1 -> String.valueOf(order.getItemCode());
                case 2 -> order.getSalesPersonName();
                case 3 -> String.valueOf(order.getUnitPrice());
                case 4 -> String.valueOf(order.getUnitPrice() * order.getQuantity());
                case 5 -> order.getCreationDate();
                case 6 -> order.getStatus();
                default -> null;
            };
            if (query!= null && query.toLowerCase().contains(searchString.toLowerCase())) {
                filteredOrders.add(order);
            }
        }

        fireTableDataChanged(); // Notify the table that the data has changed
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"Quantity", "Item Code", "SalesPerson", "Unit Price", "Total Price", "Creation Date", "Status"};
    }

    @Override
    public int[] getColumnIndices() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }
    
    @Override
    public void deleteRow(int rowIndex) {
    }

    @Override
    public ArrayList<?> getFilteredData() {
        return null;
    }

    @Override
    public void resetFilter() {
        setFilter("", 0);
    }
    
}
