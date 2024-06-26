package com.yoyo.system.model.editor;

import com.yoyo.system.model.CustomTableModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class DeleteButtonEditor extends DefaultCellEditor{
    private final JButton button;
    private boolean isButtonColumnEditor;

    public DeleteButtonEditor(CustomTableModel tableModel, JTable table) {
        super(new JCheckBox());
        this.button = new JButton();
        button.setFocusPainted(false);
        button.addActionListener((ActionEvent e) -> {
            int confirmed = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this row?",
                    "Delete row confirmation",
                    JOptionPane.YES_NO_OPTION);
            
            if (confirmed == JOptionPane.YES_OPTION) {
                stopCellEditing();
                // Call the delete method in your table model to remove the row
                tableModel.deleteRow(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()));
            } else {
                fireEditingCanceled();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setText("Delete");
        isButtonColumnEditor = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isButtonColumnEditor) {
            return null;
        } else {
            return super.getCellEditorValue();
        }
    }

    @Override
    public boolean stopCellEditing() {
        isButtonColumnEditor = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

