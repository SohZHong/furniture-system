package com.yoyo.system;

import static com.yoyo.common.constant.SystemConstants.*;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.system.gui.AdminUserTablePanel;
import com.yoyo.system.gui.CreateSaleOrderPanel;
import com.yoyo.system.gui.LoginPanel;
import com.yoyo.system.gui.OfficerAdminInvoiceOverviewPanel;
import com.yoyo.system.gui.OfficerOrderOverviewPanel;
import com.yoyo.system.gui.SalesPersonInvoiceOverviewPanel;
import com.yoyo.system.gui.SalesPersonOrderOverviewPanel;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import javax.swing.JPanel;

public class SystemPanel extends JPanel{
    
    private final PanelManager panelManager;
    
    //Initialize all needed panels
    private final LoginPanel loginPanel = new LoginPanel();
    private final OfficerOrderOverviewPanel officerOrderOverviewPanel = new OfficerOrderOverviewPanel();
    private final OfficerAdminInvoiceOverviewPanel officerAdminInvoiceOverviewPanel = new OfficerAdminInvoiceOverviewPanel();
    private final AdminUserTablePanel adminUserTablePanel = new AdminUserTablePanel();
    private final SalesPersonOrderOverviewPanel salesOrderOverviewPanel = new SalesPersonOrderOverviewPanel();
    private final CreateSaleOrderPanel createSaleOrderPanel = new CreateSaleOrderPanel();
    private final SalesPersonInvoiceOverviewPanel salesPersonInvoiceOverviewPanel = new SalesPersonInvoiceOverviewPanel();
    public static final String LOGIN_PANEL = "Login";
    // Panel for Officer
    public static final String OFFICER_ORDER_OVERVIEW_PANEL = "Officer Order Overview";
    public static final String OFFICER_INVOICE_OVERVIEW_PANEL = "Officer Invoice Overview";
    // Panel for Admin
    public static final String ADMIN_USER_OVERVIEW_PANEL = "Admin User Overview";
    // Panel for SalesPerson
    public static final String SALES_ORDER_OVERVIEW_PANEL = "Salesperson Order Overview";
    public static final String CREATE_SALE_ORDER_PANEL = "Saleperson Create Order";
    public static final String SALES_INVOICE_OVERVIEW_PANEL = "Salesperson Invoice Overview";
    
    private HashMap<String, JPanel> subPanels;
    
    public SystemPanel () throws ParseException, InterruptedException, IOException{
        
        setLayout(new CardLayout());
        
        subPanels = new HashMap<>();
        subPanels.put(LOGIN_PANEL, loginPanel);
        subPanels.put(OFFICER_ORDER_OVERVIEW_PANEL, officerOrderOverviewPanel);
        subPanels.put(OFFICER_INVOICE_OVERVIEW_PANEL,officerAdminInvoiceOverviewPanel);
        subPanels.put(ADMIN_USER_OVERVIEW_PANEL, adminUserTablePanel);
        subPanels.put(SALES_ORDER_OVERVIEW_PANEL, salesOrderOverviewPanel);
        subPanels.put(CREATE_SALE_ORDER_PANEL, createSaleOrderPanel);
        subPanels.put(SALES_INVOICE_OVERVIEW_PANEL, salesPersonInvoiceOverviewPanel);
        
        panelManager = new PanelManager(this, subPanels);
        
        //Setting initial panel
        PanelManager.showPanel(LOGIN_PANEL);
        
        //Defining a method to set panel size since windows takes task bar into consideration for size
        setPanelSize();
        
    }

    private void setPanelSize() {
        
        //JPanel only accepts dimension
        Dimension size = new Dimension(SYSTEM_WIDTH, SYSTEM_HEIGHT); 
        
        setPreferredSize(size);
        
    }
    
}
