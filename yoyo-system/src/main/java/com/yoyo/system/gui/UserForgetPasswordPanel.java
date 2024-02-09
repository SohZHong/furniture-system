/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.yoyo.system.gui;

import com.yoyo.common.utils.SecurityUtils;
import com.yoyo.services.entity.User;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.services.manager.UserManager;
import static com.yoyo.system.gui.UserProfileSettingsPanel.LOGIN_PANEL;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class UserForgetPasswordPanel extends javax.swing.JPanel {
    private final UserManager userManager;
    
    /**
     * Creates new form UserForgetPasswordPanel
     */
    public UserForgetPasswordPanel() {
        userManager = new UserManager();
        try {
            userManager.loadUsers();
        } catch (IOException ex) {
            Logger.getLogger(UserForgetPasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        Title = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UsernameLabel1 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        usernameTxt = new javax.swing.JTextField();
        newPasswordTxt = new javax.swing.JPasswordField();
        phoneNumberTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 233, 221));
        setPreferredSize(new java.awt.Dimension(1440, 800));

        Title.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        Title.setText("Forget Password?");

        UsernameLabel.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        UsernameLabel.setText("Username:");

        PasswordLabel.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        PasswordLabel.setText("New Password:");

        UsernameLabel1.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        UsernameLabel1.setText("Phone Number:");

        loginBtn.setBackground(new java.awt.Color(240, 207, 189));
        loginBtn.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        loginBtn.setText("Change Password");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        usernameTxt.setMaximumSize(new java.awt.Dimension(570, 40));

        phoneNumberTxt.setMaximumSize(new java.awt.Dimension(570, 40));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLabel1)
                    .addComponent(UsernameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(262, 262, 262))
            .addGroup(layout.createSequentialGroup()
                .addGap(547, 547, 547)
                .addComponent(loginBtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title)
                .addGap(535, 535, 535))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(Title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(backBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLabel)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLabel1)
                    .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel))
                .addGap(110, 110, 110)
                .addComponent(loginBtn)
                .addGap(109, 109, 109))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String name, phoneNumber, newPasswrd, encryptedNewPasswrd;
        name = usernameTxt.getText();
        phoneNumber = phoneNumberTxt.getText();
        newPasswrd = String.valueOf(newPasswordTxt.getPassword());
        // Check whether user exists
        User userExist = userManager.validateUser(name,phoneNumber);
        if(userExist != null){
            try {
                encryptedNewPasswrd = SecurityUtils.encodeBase64Format(newPasswrd);
                User updatedPassword = new User(name, encryptedNewPasswrd, phoneNumber, userExist.getRole());
                userManager.updateUsers(updatedPassword);
                userManager.loadUsers();
                JOptionPane.showMessageDialog(this,"Password has been updated!");
                PanelManager.showPanel(LOGIN_PANEL);

            } catch (IOException ex) {
                Logger.getLogger(UserForgetPasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }else{
            JOptionPane.showMessageDialog(this,"User does not exist!");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        PanelManager.previousPanel();
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel UsernameLabel1;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField newPasswordTxt;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
