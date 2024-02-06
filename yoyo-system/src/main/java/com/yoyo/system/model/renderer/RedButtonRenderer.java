package com.yoyo.system.model.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RedButtonRenderer implements TableCellRenderer {
    
    private final JButton button;
    private String btnText;
    
    public RedButtonRenderer(String btnText) {
        
        this.button = new JButton();
        this.button.setOpaque(true);
        this.btnText = btnText;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        
        button.setText(btnText);

        //Button select animation
        button.setForeground(new Color(215,76,76));
        button.setBackground(new Color(215,76,76));

        return button;
    }
}
