package com.yoyo.system.model.editor;

import com.yoyo.common.constant.StatusConstants;
import com.yoyo.system.model.OfficerOrderTableModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AcceptOrderButtonEditor extends DefaultCellEditor{
    private final JButton acceptButton;

    public AcceptOrderButtonEditor(OfficerOrderTableModel tableModel, JTable table) {
        super(new JCheckBox());
        acceptButton = new JButton();
        acceptButton.addActionListener((ActionEvent e) -> {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to accept this order? This could not be undone", "Accept order confirmation",
                    JOptionPane.YES_NO_OPTION);
            
            if (confirmed == JOptionPane.YES_OPTION) {
                stopCellEditing();
                try {
                    tableModel.acceptOrder(table.getSelectedRow());
                } catch (IOException ex) {
                    Logger.getLogger(AcceptOrderButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                fireEditingCanceled();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        acceptButton.setText("Accept");
        return acceptButton;
    }

    @Override
    public Object getCellEditorValue() {
        return StatusConstants.ACCEPTED_ORDER; // Always return true when button clicked
    }
}
