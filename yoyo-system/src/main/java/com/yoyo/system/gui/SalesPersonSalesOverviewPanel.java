/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.yoyo.system.gui;

import com.yoyo.services.manager.InvoiceManager;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.system.model.SalesPersonInvoiceTableModel;
import java.io.IOException;

/**
 *
 * @author user
 */
public class SalesPersonSalesOverviewPanel extends javax.swing.JPanel {
    private InvoiceManager invoiceManager;
    
    /**
     * Creates new form SalesPersonSalesOverviewPanel
     */
    public SalesPersonSalesOverviewPanel() {
        invoiceManager = new InvoiceManager();
        try {
            invoiceManager.loadInvoices();
        } catch (IOException ex) {
            System.err.println("Error loading invoices file");
        }
        initComponents();
        Object[] salesValue = invoiceManager.totalSalesforSalesPerson();
        furnitureSold.setText((String) salesValue[0]);
        salesEarned.setText("RM" + (String) salesValue[1]);
        commissionEarned.setText("RM" + (String) salesValue[2]);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn11 = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        salesEarned = new javax.swing.JLabel();
        furnitureSold = new javax.swing.JLabel();
        commissionEarned = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1440, 960));

        backBtn11.setText("Back");
        backBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn11ActionPerformed(evt);
            }
        });

        Title.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        Title.setText("SalesPerson Sales Information");

        salesEarned.setText("Testing 2");

        furnitureSold.setText("Testing 1");

        commissionEarned.setText("Testing 2");

        jLabel1.setText("Total Furniture Sold:");

        jLabel2.setText("Total Sales Earned:");

        jLabel3.setText("Total Commission Earned:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(backBtn11)
                        .addGap(97, 97, 97)
                        .addComponent(Title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(245, 245, 245)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(furnitureSold)
                            .addComponent(salesEarned)
                            .addComponent(commissionEarned))))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn11)
                    .addComponent(Title))
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(furnitureSold)
                    .addComponent(jLabel1))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesEarned)
                    .addComponent(jLabel2))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commissionEarned)
                    .addComponent(jLabel3))
                .addContainerGap(396, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn11ActionPerformed
        PanelManager.previousPanel();
    }//GEN-LAST:event_backBtn11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton backBtn10;
    private javax.swing.JButton backBtn11;
    private javax.swing.JButton backBtn2;
    private javax.swing.JButton backBtn3;
    private javax.swing.JButton backBtn4;
    private javax.swing.JButton backBtn5;
    private javax.swing.JButton backBtn6;
    private javax.swing.JButton backBtn7;
    private javax.swing.JButton backBtn8;
    private javax.swing.JButton backBtn9;
    private javax.swing.JLabel commissionEarned;
    private javax.swing.JLabel furnitureSold;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel salesEarned;
    // End of variables declaration//GEN-END:variables
}
