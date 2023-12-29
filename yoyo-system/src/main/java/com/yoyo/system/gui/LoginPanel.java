package com.yoyo.system.gui;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.common.constant.RoleConstants;
import com.yoyo.services.entity.User;
import com.yoyo.services.manager.FileManager;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.services.manager.UserManager;
import com.yoyo.system.SystemPanel;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LoginPanel extends javax.swing.JPanel {
    
    private final UserManager userManager;
    
    public LoginPanel() {
        userManager = new UserManager();
        try {
            userManager.loadUsers();
        } catch (IOException ex) {
            System.err.println("Error loading user file");
        }
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginBtn = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        companyLogo = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        forgotPasswordBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 233, 221));
        setMaximumSize(new java.awt.Dimension(1440, 960));
        setPreferredSize(new java.awt.Dimension(1440, 960));

        loginBtn.setBackground(new java.awt.Color(240, 207, 189));
        loginBtn.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        password.setMaximumSize(new java.awt.Dimension(570, 40));

        UsernameLabel.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        UsernameLabel.setText("Username:");

        PasswordLabel.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        PasswordLabel.setText("Password:");

        companyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        companyLogo.setMaximumSize(new java.awt.Dimension(200, 200));
        companyLogo.setMinimumSize(new java.awt.Dimension(200, 200));
        companyLogo.setPreferredSize(new java.awt.Dimension(200, 200));

        Title.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        Title.setText("FURNITURE SALE ORDERING MANAGEMENT SYSTEM");

        username.setMaximumSize(new java.awt.Dimension(570, 40));

        forgotPasswordBtn.setBackground(new java.awt.Color(255, 233, 221));
        forgotPasswordBtn.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        forgotPasswordBtn.setText("Forgot Password?");
        forgotPasswordBtn.setBorder(null);
        forgotPasswordBtn.setOpaque(true);
        forgotPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(Title)
                .addContainerGap(563, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addComponent(companyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(forgotPasswordBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameLabel)
                            .addComponent(PasswordLabel))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(611, 611, 611)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(companyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(Title)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UsernameLabel))
                                .addGap(53, 53, 53)
                                .addComponent(PasswordLabel))
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addComponent(forgotPasswordBtn)
                        .addGap(87, 87, 87)))
                .addComponent(loginBtn)
                .addContainerGap(168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String name, passwrd;
        name = username.getText();
        passwrd = password.getText();

        User loginUser = userManager.login(name, passwrd);
        
        // If login successful
        if (loginUser != null){
            switch (loginUser.getRole()) {
                    case RoleConstants.ADMINISTRATOR_ROLE -> PanelManager.showPanel(SystemPanel.ADMIN_USER_OVERVIEW_PANEL);
                    case RoleConstants.SALESPERSON_ROLE -> PanelManager.showPanel(SystemPanel.SALES_ORDER_OVERVIEW_PANEL);
                    case RoleConstants.OFFICE_ROLE -> PanelManager.showPanel(SystemPanel.OFFICER_ORDER_OVERVIEW_PANEL);
                    default -> {
                        JOptionPane.showMessageDialog(this, "Incorrect user role.");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Incorrect credentials. Please try again.");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void forgotPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotPasswordBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel companyLogo;
    private javax.swing.JButton forgotPasswordBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
