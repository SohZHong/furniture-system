package com.systemgui;

import javax.swing.*;

public class App {
    private JPanel panelMain;
    private JButton actionButton1;
    private JButton actionButton2;

    public App() {
        actionButton1.setText("Button 1");
        actionButton2.setText("Button 2");
        actionButton1.addActionListener(e -> JOptionPane.showMessageDialog(null, "Hello Button 1"));
        actionButton2.addActionListener(e -> JOptionPane.showConfirmDialog(panelMain, "Are you sure you want to continue?"));
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Yoyo-Furniture Sale Ordering Management System");
        jFrame.setContentPane(new App().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
