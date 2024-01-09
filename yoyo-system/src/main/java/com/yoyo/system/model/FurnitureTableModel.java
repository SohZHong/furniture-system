package com.yoyo.system.model;

import com.yoyo.services.entity.Furniture;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FurnitureTableModel extends AbstractTableModel implements CustomTableModel{
    private final ArrayList<Furniture> furnitures;
    private final ArrayList<Furniture> filteredFurnitures;
    private Furniture furniture;
   
    public FurnitureTableModel(ArrayList<Furniture> furnitures){
        this.furnitures = furnitures;
        this.filteredFurnitures = new ArrayList<>(furnitures);
    }

    @Override
    public int getRowCount() {
        return filteredFurnitures.size();
    }

    @Override
    public int getColumnCount() {
        // ID, Name, Category, Price, Description
        return 5;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //None of the columns can be edited
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return "Item Code";
            }
            case 1 -> {
                return "Name";
            }
            case 2 -> {
                return "Category";
            }
            case 3 -> {
                return "Price";
            }
            case 4 -> {
                return "Description";
            }
        }
        return null;
    }
    
        @Override
    //Class <?> User defined object
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0 -> {
                return Long.class;
            }
            case 1 -> {
                return String.class;
            }
            case 2 -> {
                return String.class;
            }
            case 3 -> {
                return Double.class;
            }
            case 4 -> {
                return String.class;
            }
        }
        return Object.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Get furniture entry from array
        furniture = filteredFurnitures.get(rowIndex);
        switch (columnIndex){
            case 0 -> {
                return furniture.getId();
            }
            case 1 -> {
                return furniture.getName();
            }
            case 2 -> {
                return furniture.getCategory();
            }
            case 3 -> {
                return furniture.getPrice();
            }
            case 4 -> {
                return furniture.getDescription();
            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        
    }
    
    @Override
    public void setFilter(String searchString, int columnIndex) {
        String query;
        filteredFurnitures.clear();
        
        // Perform search based on column
        for (Furniture furniture : furnitures) {
            query = switch (columnIndex) {
                case 0 -> String.valueOf(furniture.getId());
                case 1 -> String.valueOf(furniture.getName());
                case 2 -> furniture.getCategory();
                case 3 -> String.valueOf(furniture.getPrice());
                case 4 -> furniture.getDescription();
                default -> null;
            };
            if (query!= null && query.toLowerCase().contains(searchString.toLowerCase())) {
                filteredFurnitures.add(furniture);
            }
        }

        fireTableDataChanged(); // Notify the table that the data has changed
    }
    
    @Override
    public ArrayList<Furniture> getFilteredData() {
        return filteredFurnitures;
    }
    
    @Override
    public String[] getColumnNames() {
        return new String[]{"Item Code", "Name", "Category", "Price", "Description"};
    }

    @Override
    public int[] getColumnIndices() {
        return new int[]{0, 1, 2, 3, 4};
    }

    @Override
    public void deleteRow(int rowIndex) {
    }

    @Override
    public void resetFilter() {
        setFilter("", 0);
    }
}
