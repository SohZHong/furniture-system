/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author User
 */
public class DeclineOrderButtonEditor extends DefaultCellEditor{
    private final JButton declineBtn;

    public DeclineOrderButtonEditor(OfficerOrderTableModel tableModel, JTable table) {
        super(new JCheckBox());
        declineBtn = new JButton();
        declineBtn.addActionListener((ActionEvent e) -> {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to decline this order? This could not be undone", "Decline order confirmation",
                    JOptionPane.YES_NO_OPTION);
            
            if (confirmed == JOptionPane.YES_OPTION) {
                stopCellEditing();
                try {
                    tableModel.acceptOrder(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()));
                } catch (IOException ex) {
                    Logger.getLogger(DeclineOrderButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                fireEditingCanceled();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        declineBtn.setText("Decline");
        return declineBtn;
    }

    @Override
    public Object getCellEditorValue() {
        return StatusConstants.DECLINED_ORDER; // Always return true when button clicked
    }
}
