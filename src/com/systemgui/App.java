package com.systemgui;

import javax.swing.*;

public class App extends JFrame{
    private JPanel panelMain;
    private JButton actionButton1;
    private JButton actionButton2;

    public App() {
        showLoginPanel();
    }

    public void showLoginPanel() {
        panelMain = new LoginPanel();
        setContentPane(panelMain);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.setTitle("Yoyo-Furniture Sale Ordering Management System");
            app.setSize(1440, 960);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setResizable(false);
            app.setVisible(true);
        });
    }
}
