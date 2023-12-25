/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.yoyo.system.gui;

import com.yoyo.common.utils.FilterUtils;
import com.yoyo.services.entity.Order;
import com.yoyo.services.manager.FurnitureManager;
import com.yoyo.services.manager.OrderManager;
import com.yoyo.services.manager.PanelManager;
import static com.yoyo.system.SystemPanel.CREATE_SALE_ORDER_PANEL;
import com.yoyo.system.model.SalesPersonOrderTableModel;
import com.yoyo.system.model.editor.CustomTableCellEditor;
import com.yoyo.system.model.editor.DeleteButtonEditor;
import com.yoyo.system.model.renderer.DeleteButtonRenderer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class OrderOverviewPanel extends javax.swing.JPanel {

    private OrderManager orderManager;
    private FurnitureManager furnitureManager;
    private ArrayList<Order> orders;
    private SalesPersonOrderTableModel tableModel;
    
    public OrderOverviewPanel() {
        // Initialize managers
        furnitureManager = new FurnitureManager();
        orderManager = new OrderManager();
        // Load orders
        try {
            orderManager.loadOrders();
            orders = orderManager.getOrders();
            tableModel = new SalesPersonOrderTableModel(orders);
        } catch (IOException ex) {
            System.err.println("Error loading orders file");
        }
        
        initComponents();
        
        // Setting custom cell renderer for table
        orderOverviewTable.getColumnModel().getColumn(7).setCellRenderer(new DeleteButtonRenderer());
        
        // Setting custom cell editor for table
        orderOverviewTable.getColumnModel().getColumn(0).setCellEditor(new CustomTableCellEditor(FilterUtils.createDigitFilter()));
        orderOverviewTable.getColumnModel().getColumn(7).setCellEditor(new DeleteButtonEditor(tableModel,orderOverviewTable));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPane = new javax.swing.JScrollPane();
        orderOverviewTable = new javax.swing.JTable();
        cancelBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        createOrderBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        tableColumnBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1440, 960));

        orderOverviewTable.setModel(tableModel);
        orderOverviewTable.setAutoscrolls(false);
        orderOverviewTable.setRowHeight(68);
        tableScrollPane.setViewportView(orderOverviewTable);

        cancelBtn.setText("Reset Changes");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        confirmBtn.setText("Save Changes");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        createOrderBtn.setText("Create Order");
        createOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOrderBtnActionPerformed(evt);
            }
        });

        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchInput)
                    .addComponent(tableColumnBox)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(createOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        try {
            orderManager.loadOrders();
            tableModel.setFilter("", 0);
        } catch (IOException ex) {
            Logger.getLogger(OrderOverviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        orderManager.saveOrders();
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void createOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOrderBtnActionPerformed
        PanelManager.showPanel(CREATE_SALE_ORDER_PANEL);
    }//GEN-LAST:event_createOrderBtnActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String query = searchInput.getText();
        int index = tableColumnBox.getSelectedIndex();

        tableModel.setFilter(query, index);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        tableModel.setFilter("", 0);
    }//GEN-LAST:event_resetBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton createOrderBtn;
    private javax.swing.JTable orderOverviewTable;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> tableColumnBox;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
