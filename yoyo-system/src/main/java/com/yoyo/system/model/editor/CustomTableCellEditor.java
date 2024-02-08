package com.yoyo.system.model.editor;


import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    private TableCellEditor editor;
    private final JTextField cellField;
    private final InputVerifier verifier;
    private Object originalValue;
    
    public CustomTableCellEditor(InputVerifier verifier){
        this.verifier = verifier;
        this.cellField = new JTextField();
        cellField.setInputVerifier(verifier);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        originalValue = value; //Update value of text field after validation successful
        cellField.setText(String.valueOf( value));
        editor = new DefaultCellEditor(cellField);
        
        return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    @Override
    public boolean stopCellEditing(){
        if (!verifier.verify(cellField)){
            cellField.setText(String.valueOf( originalValue)); //Restore original value if failed validation
            return false;
        }
        
        return super.stopCellEditing();
    }

    @Override
    public Object getCellEditorValue() {
        // Retrieve the text from the JTextField
        String text = cellField.getText();

        // Check the original value's class type and convert the text back using reflection
        if (originalValue != null) {
            Class<?> originalClass = originalValue.getClass();

            try {
                if (originalClass == Integer.class) {
                    return Integer.valueOf(text);
                } else if (originalClass == Double.class) {
                    return Double.valueOf(text);
                } else if (originalClass == Float.class) {
                    return Float.valueOf(text);
                }
            } catch (NumberFormatException e) {
                // Handle conversion errors, e.g., show an error message
                JOptionPane.showMessageDialog(cellField, "Invalid input for " + originalClass.getSimpleName());
                return originalValue; // Return the original value on conversion error
            }
        }

        // Default case: return the text as a String
        return text;
    }
    

}
