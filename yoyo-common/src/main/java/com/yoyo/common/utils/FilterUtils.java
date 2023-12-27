package com.yoyo.common.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FilterUtils {
    public static DocumentFilter createDigitFilter() {
        return new DigitFilter();
    }
    
    public static DocumentFilter createRegexFilter(String regex) {
        return new RegexFilter(regex);
    }
    
    private static class DigitFilter extends DocumentFilter {
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            currentText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

            if (isValidInput(currentText)) {
                super.replace(fb, offset, length, text, attrs);
            }
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
    
     private static class RegexFilter extends DocumentFilter {
        private final String regex;

        public RegexFilter(String regex) {
            this.regex = regex;
        }

        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            currentText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

            if (isValidInput(currentText, regex)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isValidInput(String input, String regex) {
            return input.matches(regex);
        }
    }
}
