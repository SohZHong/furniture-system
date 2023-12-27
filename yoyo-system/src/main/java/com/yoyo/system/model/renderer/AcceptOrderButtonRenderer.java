/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoyo.system.model.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author User
 */
public class AcceptOrderButtonRenderer extends DefaultTableCellRenderer{
    private final JButton acceptButton;

    public AcceptOrderButtonRenderer() {
        acceptButton = new JButton();
        acceptButton.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        acceptButton.setText("Accept");

        //Button select animation
        acceptButton.setForeground(new Color(5,169,92));
        acceptButton.setBackground(new Color(5,169,92));
        return acceptButton;
    }
}
