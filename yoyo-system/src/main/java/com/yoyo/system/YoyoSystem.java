package com.yoyo.system;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class YoyoSystem {

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> {
            try {
                new SystemProgram();
            } catch (ParseException ex) {
                Logger.getLogger(SystemProgram.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SystemProgram.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SystemProgram.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
