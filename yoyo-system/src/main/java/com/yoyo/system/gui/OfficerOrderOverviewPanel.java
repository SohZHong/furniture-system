package com.yoyo.system.gui;
import com.yoyo.common.constant.StatusConstants;
import com.yoyo.services.entity.Order;
import com.yoyo.services.entity.OrderReport;
import com.yoyo.services.manager.InvoiceManager;
import com.yoyo.services.manager.OrderManager;
import com.yoyo.services.manager.PanelManager;
import static com.yoyo.system.SystemPanel.OFFICER_INVOICE_OVERVIEW_PANEL;
import static com.yoyo.system.SystemPanel.OFFICER_ORDER_OVERVIEW_PANEL;
import static com.yoyo.system.SystemPanel.PROFILE_PANEL;
import com.yoyo.system.model.OfficerOrderTableModel;
import com.yoyo.system.model.editor.AcceptOrderButtonEditor;
import com.yoyo.system.model.editor.DeclineOrderButtonEditor;
import com.yoyo.system.model.renderer.GreenButtonRenderer;
import com.yoyo.system.model.renderer.RedButtonRenderer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class OfficerOrderOverviewPanel extends javax.swing.JPanel {

    private OrderManager orderManager;
    private ArrayList<Order> orders;
    private OfficerOrderTableModel tableModel;
    private InvoiceManager invoiceManager;
    
    public OfficerOrderOverviewPanel() {
        // Initialize managers
        orderManager = new OrderManager();
        invoiceManager = new InvoiceManager();
        // Load orders
        try {
            orderManager.loadOrders();
            orders = orderManager.getOrders();
            tableModel = new OfficerOrderTableModel(orders);
        } catch (IOException ex) {
            System.err.println("Error loading orders file");
        }
        
        initComponents();
        
        // Apply row filter for pending status
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        sorter.setRowFilter(RowFilter.regexFilter(StatusConstants.PENDING_ORDER, 6));
        orderOverviewTable.setRowSorter(sorter);
        
        // Setting custom cell renderer for table        
        orderOverviewTable.getColumnModel().getColumn(6).setCellRenderer(new GreenButtonRenderer("Accept"));
        orderOverviewTable.getColumnModel().getColumn(7).setCellRenderer(new RedButtonRenderer("Decline"));
        
        // Setting custom cell editor for table
        orderOverviewTable.getColumnModel().getColumn(6).setCellEditor(new AcceptOrderButtonEditor(tableModel, orderOverviewTable));
        orderOverviewTable.getColumnModel().getColumn(7).setCellEditor(new DeclineOrderButtonEditor(tableModel, orderOverviewTable));
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
        generateReportBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        tableColumnBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        companyIcon = new javax.swing.JLabel();
        orderNavBtn1 = new javax.swing.JButton();
        invoiceNavBtn = new javax.swing.JButton();
        profileNavBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1440, 700));

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

        generateReportBtn.setText("Generate Report");
        generateReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportBtnActionPerformed(evt);
            }
        });

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

        companyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/YOYO.png"))); // NOI18N

        orderNavBtn1.setText("Order");
        orderNavBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNavBtn1ActionPerformed(evt);
            }
        });

        invoiceNavBtn.setText("Invoice");
        invoiceNavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNavBtnActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(companyIcon)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                            .addComponent(orderNavBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(invoiceNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(profileNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(generateReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyIcon)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(orderNavBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profileNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        try {
            orderManager.loadOrders();
            tableModel.resetTable();
        } catch (IOException ex) {
            Logger.getLogger(OfficerOrderOverviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        
        try {
            orderManager.saveOrders();
            orderManager.loadOrders();
            tableModel.resetFilter();
            // Get all the accepted orders from the table
            invoiceManager.generateInvoices(tableModel.getAcceptedOrders());
        } catch (IOException ex) {
            Logger.getLogger(OfficerOrderOverviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void generateReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportBtnActionPerformed
        OrderReport report = new OrderReport(orderOverviewTable);
        report.generateReport();
    }//GEN-LAST:event_generateReportBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String query = searchInput.getText();
        int index = tableColumnBox.getSelectedIndex();

        tableModel.setFilter(query, index);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        tableModel.resetFilter();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void invoiceNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNavBtnActionPerformed
        PanelManager.showPanel(OFFICER_INVOICE_OVERVIEW_PANEL);
    }//GEN-LAST:event_invoiceNavBtnActionPerformed

    private void orderNavBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNavBtn1ActionPerformed
        PanelManager.showPanel(OFFICER_ORDER_OVERVIEW_PANEL);
    }//GEN-LAST:event_orderNavBtn1ActionPerformed

    private void profileNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileNavBtnActionPerformed
        PanelManager.showPanel(PROFILE_PANEL);
    }//GEN-LAST:event_profileNavBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel companyIcon;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton generateReportBtn;
    private javax.swing.JButton invoiceNavBtn;
    private javax.swing.JButton orderNavBtn1;
    private javax.swing.JTable orderOverviewTable;
    private javax.swing.JButton profileNavBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> tableColumnBox;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
