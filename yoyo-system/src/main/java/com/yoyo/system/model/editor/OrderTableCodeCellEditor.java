package com.yoyo.system.model.editor;

import com.yoyo.services.entity.Furniture;
import com.yoyo.services.manager.FurnitureManager;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;


public class OrderTableCodeCellEditor extends AbstractCellEditor implements TableCellEditor{
    private FurnitureManager furnitureManager;
    private ArrayList<Furniture> furnitures;
    private JComboBox<Long> itemCodes;
    
    public OrderTableCodeCellEditor() {
        this.itemCodes = new JComboBox<>();
        furnitureManager = new FurnitureManager();
        try {
            furnitureManager.loadFurnitures();
            furnitures = furnitureManager.getFurnitures();
        } catch (IOException ex) {
            Logger.getLogger(OrderTableCodeCellEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Object getCellEditorValue() {
        return itemCodes.getSelectedItem();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Clear existing items in the JComboBox
        itemCodes.removeAllItems();

        // Populate the JComboBox with item codes from furnitures
        for (Furniture furniture : furnitures) {
            itemCodes.addItem(furniture.getId());
        }
        itemCodes.setSelectedItem(value);
        
        return itemCodes;
    }
}
