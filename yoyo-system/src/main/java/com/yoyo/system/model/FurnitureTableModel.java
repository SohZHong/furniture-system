package com.yoyo.system.model;

import com.yoyo.services.entity.Furniture;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FurnitureTableModel extends AbstractTableModel{
    private final ArrayList<Furniture> furnitures;
    private Furniture furniture;
   
    public FurnitureTableModel(ArrayList<Furniture> furnitures){
        this.furnitures = furnitures;
    }

    @Override
    public int getRowCount() {
        return furnitures.size();
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
        furniture = furnitures.get(rowIndex);
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
        furniture = furnitures.get(rowIndex);
        switch (columnIndex){
            case 0 -> furniture.setId((Long)value);
            case 1 -> furniture.setName((String) value);
            case 2 -> furniture.setCategory((String) value);
            case 3 -> furniture.setPrice((Double) value);
            case 4 -> furniture.setDescription((String) value);
        }
    }
}
