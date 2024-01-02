package com.yoyo.system.gui;

import com.yoyo.services.entity.Invoice;
import com.yoyo.services.manager.ApplicationContext;
import com.yoyo.services.manager.InvoiceManager;
import com.yoyo.services.manager.PanelManager;
import static com.yoyo.system.SystemPanel.SALES_INVOICE_OVERVIEW_PANEL;
import static com.yoyo.system.SystemPanel.SALES_ORDER_OVERVIEW_PANEL;
import com.yoyo.system.model.SalesPersonInvoiceTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SalesPersonInvoiceOverviewPanel extends javax.swing.JPanel {

    private InvoiceManager invoiceManager;
    private ArrayList<Invoice> invoices;
    private SalesPersonInvoiceTableModel tableModel;
    
    public SalesPersonInvoiceOverviewPanel() {
        // Initialize managers
        invoiceManager = new InvoiceManager();
        // Load orders
        try {
            invoiceManager.loadInvoices();
            invoices = invoiceManager.getInvoices();
            tableModel = new SalesPersonInvoiceTableModel(invoices);
        } catch (IOException ex) {
            System.err.println("Error loading invoices file");
        }
        
        initComponents();
        
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        // Row filter for invoice payment status
        RowFilter<Object, Object> paymentFilter = new RowFilter<Object, Object>() {
            public boolean include(RowFilter.Entry<? extends Object, ? extends Object> entry) {
                // Check if the value in the 4th column is false
                Object value = entry.getValue(4);
                return Boolean.FALSE.equals(value);
            }
        };
        // Row filter for specifying saleperson's own sales
        RowFilter<Object, Object> nameFilter = RowFilter.regexFilter(ApplicationContext.getLoginUser().getName(), 2);
        
        // Create a list to hold the filters
        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
        filters.add(paymentFilter);
        filters.add(nameFilter);
        
        // Combine filters with AND condition
        RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(combinedFilter);
        invoiceOverviewTable.setRowSorter(sorter);
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
        invoiceOverviewTable = new javax.swing.JTable();
        searchInput = new javax.swing.JTextField();
        tableColumnBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        confirmBtn3 = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        companyIcon = new javax.swing.JLabel();
        orderNavBtn = new javax.swing.JButton();
        invoiceNavBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1440, 960));

        invoiceOverviewTable.setModel(tableModel);
        invoiceOverviewTable.setAutoscrolls(false);
        invoiceOverviewTable.setRowHeight(68);
        tableScrollPane.setViewportView(invoiceOverviewTable);

        tableColumnBox.setModel(new javax.swing.DefaultComboBoxModel<>(tableModel.getColumnNames()));

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        confirmBtn3.setText("Save Changes");
        confirmBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtn3ActionPerformed(evt);
            }
        });

        cancelBtn.setText("Reset Changes");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        companyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/YOYO.png"))); // NOI18N

        orderNavBtn.setText("Order");
        orderNavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNavBtnActionPerformed(evt);
            }
        });

        invoiceNavBtn.setText("Invoice");
        invoiceNavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNavBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(companyIcon)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orderNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(invoiceNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyIcon)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(orderNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchInput)
                    .addComponent(tableColumnBox)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(confirmBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String query = searchInput.getText();
        int index = tableColumnBox.getSelectedIndex();

        tableModel.setFilter(query, index);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        tableModel.resetFilter();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void confirmBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn3ActionPerformed
        int result = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to save the invoices?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            try {
                invoiceManager.saveInvoices();
                invoiceManager.loadInvoices();
                tableModel.resetFilter();
            } catch (IOException ex) {
                Logger.getLogger(SalesPersonInvoiceOverviewPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmBtn3ActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        try {
            invoiceManager.loadInvoices();
            tableModel.resetFilter();
        } catch (IOException ex) {
            Logger.getLogger(SalesPersonOrderOverviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void orderNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNavBtnActionPerformed
        PanelManager.showPanel(SALES_ORDER_OVERVIEW_PANEL);
    }//GEN-LAST:event_orderNavBtnActionPerformed

    private void invoiceNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNavBtnActionPerformed
        PanelManager.showPanel(SALES_INVOICE_OVERVIEW_PANEL);
    }//GEN-LAST:event_invoiceNavBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel companyIcon;
    private javax.swing.JButton confirmBtn3;
    private javax.swing.JButton invoiceNavBtn;
    private javax.swing.JTable invoiceOverviewTable;
    private javax.swing.JButton orderNavBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> tableColumnBox;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
