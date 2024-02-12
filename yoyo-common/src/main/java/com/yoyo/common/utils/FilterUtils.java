package com.yoyo.common.utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FilterUtils {
    public static InputVerifier createDigitFilter() {
        return new DigitFilter();
    }
    
    public static InputVerifier createRegexFilter(String regex) {
        return new RegexFilter(regex);
    }
    
    private static class DigitFilter extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            //Get the input of textfield
            String text = ((JTextField) input).getText();

            boolean isValid = isValidInput(text);
            if (isValid && !text.isBlank()) {
                return true;
            }
            else {
               JOptionPane.showMessageDialog(input, "Invalid digit format");
            }

            return isValid;
        }

        private boolean isValidInput(String input) {
            try {
                int value = Integer.parseInt(input);
                return value > 0;
            } catch (NumberFormatException e) {
                return false; // Not a valid integer
            }
        }
    }
    
     private static class RegexFilter extends InputVerifier {
        private final String regex;

        public RegexFilter(String regex) {
            this.regex = regex;
        }

        @Override
        public boolean verify(JComponent input) {
            //Get the input of textfield
            String text = ((JTextField) input).getText();

            boolean isValid = text.matches(regex);

            if (isValid && !text.isBlank()) {
                return true;
            }
            else {
               JOptionPane.showMessageDialog(input, "Invalid format");
            }

            return isValid;
        }

       
    }
}
