package com.yoyo.system.model.editor;

import com.yoyo.services.manager.UserManager;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class UserRoleCellEditor extends AbstractCellEditor implements TableCellEditor{
    private ArrayList<String> rolesList;
    private JComboBox roleField;
    private final UserManager userManager;

    public UserRoleCellEditor(UserManager userManager) {
        this.roleField = new JComboBox<>();
        this.userManager = userManager;
    }
    
    @Override
    public Object getCellEditorValue() {
        return roleField.getSelectedItem();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Clear existing items in the JComboBox
        roleField.removeAllItems();

        // Populate the JComboBox with user roles
        rolesList = userManager.getRoles();
        roleField.setModel(new DefaultComboBoxModel<>(rolesList.toArray(new String[rolesList.size()])));
        
        roleField.setSelectedItem(value);
        
        return roleField;
    }
}
