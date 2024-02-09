package com.yoyo.system.dialog;

import com.yoyo.common.constant.FilterConstants;
import com.yoyo.common.utils.SecurityUtils;
import com.yoyo.services.entity.User;
import com.yoyo.services.manager.UserManager;
import java.awt.Frame;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public final class AddUserDialog extends JDialog {
    private final JTextField usernameField;
    private final JTextField passwordField;
    private final JTextField phoneNumberField;
    private final JComboBox roleField;
    
    public AddUserDialog(UserManager userManager) {
        super((Frame) null, "Login", true);
        usernameField = new JTextField();
        passwordField = new JTextField();
        phoneNumberField = new JTextField();
        roleField = new JComboBox();

        // Assigning values to combobox
        ArrayList<String> rolesList = userManager.getRoles();
        roleField.setModel(new DefaultComboBoxModel<>(rolesList.toArray(new String[rolesList.size()])));
        
        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField,
                "Phone Number:", phoneNumberField,
                "Role:", roleField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add New User", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            if (isValidInput(userManager).equals("true")) {
                String encryptedPassword = SecurityUtils.encodeBase64Format(getPassword());
                userManager.addUsers(new User(
                        getUsername(),
                        encryptedPassword,
                        getPhoneNumber(),
                        getRole()   
                ));
                userManager.saveUsers();
            } else {
                JOptionPane.showMessageDialog(null, isValidInput(userManager));
            }
        }

        dispose();
    }

    private String isValidInput(UserManager userManager) {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();
        String enteredPhoneNumber = phoneNumberField.getText();
        String enteredRole = (String) roleField.getSelectedItem();
        String checkWhetherUserInfoExists = userManager.checkIfDataExists(enteredUsername, enteredPhoneNumber);
        if(checkWhetherUserInfoExists.equals("true")){
            if(!enteredUsername.matches(FilterConstants.USERNAME_REGEX)){
                return "Incorrect username format. Username should not include numbers.";
            }else if(!enteredPassword.matches(FilterConstants.PASSWORD_REGEX)){
                return "Incorrect password format. Password should be more than 6 characters.";
            }else if(!enteredPhoneNumber.matches(FilterConstants.PHONE_NUMBER_REGEX)){
                return "Incorrect phone number format. Make sure your input is a Malaysian format phone number.";
            }else if(enteredRole.isBlank()){
                return "Your role should not be empty!";
            }
            return "true";
        }
        return checkWhetherUserInfoExists;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
    
    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public String getRole() {
        return (String) roleField.getSelectedItem();
    }
}
