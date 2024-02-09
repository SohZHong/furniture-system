package com.yoyo.system.model.renderer;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class ButtonRenderer extends DefaultTableCellRenderer{
    protected final JButton button;
    protected String btnText;
    
    public ButtonRenderer(String btnText) {
        
        this.button = new JButton();
        this.btnText = btnText;
        initializeButton();
    }

    protected void initializeButton() {
        button.setOpaque(true);
        button.setText(btnText);
    }

    @Override
    public abstract Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column);
}
