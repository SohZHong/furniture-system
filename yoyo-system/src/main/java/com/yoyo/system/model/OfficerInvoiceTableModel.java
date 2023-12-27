package com.yoyo.system.model;

import com.yoyo.services.entity.Invoice;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class OfficerInvoiceTableModel extends AbstractTableModel implements CustomTableModel{
    private final ArrayList<Invoice> invoices;
    private final ArrayList<Invoice> filteredInvoices;
    private Invoice invoice;
    
    private final boolean[] canEdit = new boolean[]{
            false, false, false, false, false
    };
    
    public OfficerInvoiceTableModel(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
        this.filteredInvoices = new ArrayList<>(invoices);
    }
    
    @Override
    public int getRowCount() {
        return filteredInvoices.size();
    }

    @Override
    public int getColumnCount() {
        // invoiceNo, totalPrice, salesPersonName, customerName, status
        return 5;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0: return String.class;
            case 1: return Double.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
        }
        return Object.class;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "Invoice ID";
            case 1: return "Total Price";
            case 2: return "SalesPerson";
            case 3: return "Customer Name";
            case 4: return "Status";
        }
        return null;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        invoice = filteredInvoices.get(rowIndex);
        switch (columnIndex){
            case 0: return invoice.getInvoiceNo();
            case 1: return invoice.getTotalPrice();
            case 2: return invoice.getSalesPersonName();
            case 3: return invoice.getCustomerName();
            case 4: return invoice.getStatus();
        }
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
//        order = filteredOrders.get(rowIndex);
//        switch (columnIndex){
//            case 6:
//                order.setStatus( (String) value );
//                break;
//        }
//        
//        // Now, find the corresponding order in the original 'orders' list and update it
//        for (Order originalOrder : orders) {
//            if (originalOrder.equals(order)) {
//                originalOrder.copyFrom(order);
//                break;
//            }
//        }
//        
//        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public void setFilter(String searchString, int columnIndex) {
        String query;
        filteredInvoices.clear();
        
        // Perform search based on column
        for (Invoice invoice : invoices) {
            query = switch (columnIndex) {
                case 0 -> invoice.getInvoiceNo();
                case 1 -> String.valueOf(invoice.getTotalPrice());
                case 2 -> invoice.getSalesPersonName();
                case 3 -> invoice.getCustomerName();
                case 4 -> invoice.getStatus();
                default -> null;
            };
            if (query!= null && query.toLowerCase().contains(searchString.toLowerCase())) {
                filteredInvoices.add(invoice);
            }
        }

        fireTableDataChanged(); // Notify the table that the data has changed
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"Invoice ID", "Total Price", "SalesPerson", "Customer Name", "Status"};
    }
    
    @Override
    public int[] getColumnIndices() {
        return new int[]{0, 1, 2, 3, 4};
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
