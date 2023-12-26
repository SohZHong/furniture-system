package com.yoyo.system.model;

import java.util.ArrayList;

public interface TableModel{

    public void setFilter(String searchString, int columnIndex);

    public void resetFilter();
    
    public ArrayList<?> getFilteredData();
    
    public String[] getColumnNames();

    public int[] getColumnIndices();
    
    public void deleteRow(int rowIndex);
}
