package com.yoyo.system.model.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class RedButtonRenderer extends ButtonRenderer {

    public RedButtonRenderer(String btnText) {
        super(btnText);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        button.setText(btnText);

        // Button select animation
        button.setForeground(new Color(215, 76, 76));
        button.setBackground(new Color(215, 76, 76));

        return button;
    }
}
