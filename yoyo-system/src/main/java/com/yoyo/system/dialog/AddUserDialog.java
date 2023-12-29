package com.yoyo.system.dialog;

import com.yoyo.common.constant.FilterConstants;
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
    private final JComboBox roleField;

    public AddUserDialog(UserManager userManager) {
        super((Frame) null, "Login", true);

        usernameField = new JTextField();
        passwordField = new JTextField();
        roleField = new JComboBox();

        // Assigning values to combobox
        ArrayList<String> rolesList = userManager.getRoles();
        roleField.setModel(new DefaultComboBoxModel<>(rolesList.toArray(new String[rolesList.size()])));
        
        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField,
                "Role:", roleField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add New User", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            if (isValidInput()) {
                userManager.addUsers(new User(
                        getUsername(),
                        getPassword(),
                        getRole()
                ));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid user credentials");
            }
        }

        dispose();
    }

    private boolean isValidInput() {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();
        String enteredRole = (String) roleField.getSelectedItem();

        return enteredUsername.matches(FilterConstants.USERNAME_REGEX) && enteredPassword.matches(FilterConstants.PASSWORD_REGEX) && !enteredRole.isBlank();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getRole() {
        return (String) roleField.getSelectedItem();
    }
}
