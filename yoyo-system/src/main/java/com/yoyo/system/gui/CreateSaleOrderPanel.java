package com.yoyo.system.gui;

import com.yoyo.common.utils.FilterUtils;
import com.yoyo.services.entity.Furniture;
import com.yoyo.services.entity.Order;
import com.yoyo.services.manager.ApplicationContext;
import com.yoyo.services.manager.FurnitureManager;
import com.yoyo.services.manager.OrderManager;
import com.yoyo.services.manager.PanelManager;
import static com.yoyo.system.SystemPanel.PROFILE_PANEL;
import static com.yoyo.system.SystemPanel.SALES_INVOICE_OVERVIEW_PANEL;
import static com.yoyo.system.SystemPanel.SALES_ORDER_OVERVIEW_PANEL;
import com.yoyo.system.model.FurnitureTableModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

public class CreateSaleOrderPanel extends javax.swing.JPanel {

    private OrderManager orderManager;
    private FurnitureManager furnitureManager;
    private ArrayList<Furniture> furnitures;
    private Furniture selectedFurniture;
    private FurnitureTableModel tableModel;
    private int quantity;
    /**
     * Creates new form CreateSaleOrderPanel
     */
    public CreateSaleOrderPanel() {
        // Initialize managers
        furnitureManager = new FurnitureManager();
        orderManager = new OrderManager();
        // Load furnitures
        try {
            furnitureManager.loadFurnitures();
            furnitures = furnitureManager.getFurnitures();
            tableModel = new FurnitureTableModel(furnitures);
        } catch (IOException ex) {
            System.err.println("Error loading furniture file");
        }
        
        initComponents();
        
        // Obtain list item
        createOrderTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
           if (!e.getValueIsAdjusting()) {
               // Get the selected row and read values from the model
               int selectedRow = createOrderTable.getSelectedRow();
               if (selectedRow != -1) {
                   selectedFurniture = tableModel.getFilteredData().get(selectedRow);
               }
           }
        });
        
        // Assign filter to ensure quantity > 0
        quantityInputField.setInputVerifier(FilterUtils.createDigitFilter());
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
        createOrderTable = new javax.swing.JTable();
        quantityLabel = new javax.swing.JLabel();
        quantityInputField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        tableColumnBox = new javax.swing.JComboBox<>();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        invoiceNavBtn = new javax.swing.JButton();
        orderNavBtn = new javax.swing.JButton();
        companyIcon = new javax.swing.JLabel();
        profileNavBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1440, 900));

        createOrderTable.setModel(tableModel);
        createOrderTable.setAutoscrolls(false);
        createOrderTable.setRowHeight(68);
        createOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createOrderTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(createOrderTable);

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        quantityLabel.setText("Quantity: ");

        quantityInputField.setMinimumSize(new java.awt.Dimension(183, 68));
        quantityInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityInputFieldActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
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

        invoiceNavBtn.setText("Invoice");
        invoiceNavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNavBtnActionPerformed(evt);
            }
        });

        orderNavBtn.setText("Order");
        orderNavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNavBtnActionPerformed(evt);
            }
        });

        companyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/YOYO.png"))); // NOI18N

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tableColumnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 177, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(companyIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(orderNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoiceNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(profileNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(orderNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profileNavBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(companyIcon))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantityInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantityLabel)))
                .addGap(209, 209, 209))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createOrderTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createOrderTableMouseClicked

    private void quantityInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityInputFieldActionPerformed
        
    }//GEN-LAST:event_quantityInputFieldActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        try {
            // Show ConfirmCancelDialog to get additional input (replace null with your frame reference)
            String customerInput = JOptionPane.showInputDialog(null, "Please Enter Customer Name");
            
            // Check if customerInput is not null (user didn't click Cancel) and not empty
            if (customerInput != null && !customerInput.trim().isEmpty()) {
                quantity = Integer.parseInt(quantityInputField.getText());
                orderManager.loadOrders();
                orderManager.addOrders(
                    new Order(
                            quantity, 
                            selectedFurniture.getId(),
                            ApplicationContext.getLoginUser().getName(),
                            customerInput,
                            selectedFurniture.getPrice() * quantity
                    )
                );
                orderManager.saveOrders();

                // Show confirmation message
                JOptionPane.showMessageDialog(null, "Save successful", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else if (customerInput == null) {
                // Show message when user clicks Cancel
                JOptionPane.showMessageDialog(null, "Action cancelled", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show error message if input is empty
                JOptionPane.showMessageDialog(null, "Please enter a valid customer name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Show confirmation message
        JOptionPane.showMessageDialog(null, "Save successful", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_confirmBtnActionPerformed
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        PanelManager.previousPanel();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String query = searchInput.getText();
        int index = tableColumnBox.getSelectedIndex();

        tableModel.setFilter(query, index);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        tableModel.setFilter("", 0);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void invoiceNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNavBtnActionPerformed
        PanelManager.showPanel(SALES_INVOICE_OVERVIEW_PANEL);
    }//GEN-LAST:event_invoiceNavBtnActionPerformed

    private void orderNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNavBtnActionPerformed
        PanelManager.showPanel(SALES_ORDER_OVERVIEW_PANEL);
    }//GEN-LAST:event_orderNavBtnActionPerformed

    private void profileNavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileNavBtnActionPerformed
        PanelManager.showPanel(PROFILE_PANEL);
    }//GEN-LAST:event_profileNavBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel companyIcon;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTable createOrderTable;
    private javax.swing.JButton invoiceNavBtn;
    private javax.swing.JButton orderNavBtn;
    private javax.swing.JButton profileNavBtn;
    private javax.swing.JTextField quantityInputField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> tableColumnBox;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
