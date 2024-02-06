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
public class GreenButtonRenderer extends DefaultTableCellRenderer{
    private final JButton button;
    private String btnText;

    public GreenButtonRenderer(String btnText) {
        this.button = new JButton();
        this.button.setOpaque(true);
        this.btnText = btnText;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        button.setText(btnText);

        //Button select animation
        button.setForeground(new Color(5,169,92));
        button.setBackground(new Color(5,169,92));
        return button;
    }
}
