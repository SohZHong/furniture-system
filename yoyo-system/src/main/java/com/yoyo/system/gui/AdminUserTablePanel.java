package com.yoyo.system.gui;

import com.yoyo.common.constant.FilterConstants;
import com.yoyo.common.utils.FilterUtils;
import com.yoyo.services.entity.User;
import com.yoyo.services.manager.ApplicationContext;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.services.manager.UserManager;
import static com.yoyo.system.SystemPanel.PROFILE_PANEL;
import com.yoyo.system.dialog.AddUserDialog;
import com.yoyo.system.model.AdminUserTableModel;
import com.yoyo.system.model.editor.CustomTableCellEditor;
import com.yoyo.system.model.editor.DeleteButtonEditor;
import com.yoyo.system.model.editor.UserRoleCellEditor;
import com.yoyo.system.model.renderer.RedButtonRenderer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class AdminUserTablePanel extends javax.swing.JPanel {

    private UserManager userManager;
    private ArrayList<User> users;
    private AdminUserTableModel tableModel;
    /**
     * Creates new form CreateSaleOrderPanel
     */
    public AdminUserTablePanel() {
        // Initialize managers
        userManager = new UserManager();
        // Load Users
        try {
            userManager.loadUsers();
            users = userManager.getUsers();
            tableModel = new AdminUserTableModel(users);
        } catch (IOException ex) {
            System.err.println("Error loading user file");
        }
        
        initComponents();
        
        
        // Assign filter to ensure input consistency
        userOverviewTable.getColumnModel().getColumn(0).setCellEditor(new CustomTableCellEditor(FilterUtils.createRegexFilter(FilterConstants.USERNAME_REGEX)));
        userOverviewTable.getColumnModel().getColumn(2).setCellEditor(new CustomTableCellEditor(FilterUtils.createRegexFilter(FilterConstants.PHONE_NUMBER_REGEX)));
        
        // Setting custom cell renderer for table
        userOverviewTable.getColumnModel().getColumn(4).setCellRenderer(new RedButtonRenderer("Delete"));
        
        // Setting custom cell editor for table
        userOverviewTable.getColumnModel().getColumn(3).setCellEditor(new UserRoleCellEditor(userManager));
        userOverviewTable.getColumnModel().getColumn(4).setCellEditor(new DeleteButtonEditor(tableModel,userOverviewTable));

        // Setting a RowFilter to exclude the row with the login user name
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        RowFilter<Object, Object> rowFilter = new RowFilter<Object, Object>() {
            @Override
            public boolean include(Entry<? extends Object, ? extends Object> entry) {
                String userName = (String) entry.getValue(0);
                return !userName.equals(ApplicationContext.getLoginUser().getName());
            }
        };
        sorter.setRowFilter(rowFilter);
        userOverviewTable.setRowSorter(sorter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        companyIcon = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        userOverviewTable = new javax.swing.JTable();
        tableColumnBox = new javax.swing.JComboBox<>();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        createUserBtn = new javax.swing.JButton();
        profileNavBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1440, 700));

        companyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/YOYO.png"))); // NOI18N

        userOverviewTable.setModel(tableModel);
        userOverviewTable.setAutoscrolls(false);
        userOverviewTable.setRowHeight(68);
        userOverviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userOverviewTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(userOverviewTable);

        tableColumnBox.setModel(new javax.swing.DefaultComboBoxModel<>(tableModel.getColumnNames()));

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        confirmBtn.setText("Save Changes");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Reset Changes");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        createUserBtn.setText("Create User");
        createUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserBtnActionPerformed(evt);
            }
        });

        profileNavBtn.setText("Profile");
        profileNavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileNavBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(companyIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profileNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyIcon)
                    .addComponent(profileNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(searchInput)
                        .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(210, 210, 210))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userOverviewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userOverviewTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userOverviewTableMouseClicked
    
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String query = searchInput.getText();
        int index = tableColumnBox.getSelectedIndex();

        tableModel.setFilter(query, index);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        tableModel.setFilter("", 0);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        int result = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to save the changes made?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            try {
                userManager.saveUsers();
                userManager.loadUsers();
                tableModel.resetFilter();
            } catch (IOException ex) {
                Logger.getLogger(AdminUserTablePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        try {
            userManager.loadUsers();
            tableModel.resetFilter();
        } catch (IOException ex) {
            Logger.getLogger(SalesPersonOrderOverviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserBtnActionPerformed
        new AddUserDialog(userManager);
    }//GEN-LAST:event_createUserBtnActionPerformed

    private void profileNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileNavBtnActionPerformed
        PanelManager.showPanel(PROFILE_PANEL);
    }//GEN-LAST:event_profileNavBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel companyIcon;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton createUserBtn;
    private javax.swing.JButton profileNavBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> tableColumnBox;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable userOverviewTable;
    // End of variables declaration//GEN-END:variables
}
