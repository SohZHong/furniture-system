package com.yoyo.system;

import static com.yoyo.common.constant.SystemConstants.*;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.system.gui.CreateSaleOrderPanel;
import com.yoyo.system.gui.LoginPanel;
import com.yoyo.system.gui.OrderOverviewPanel;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

public class SystemPanel extends JPanel{
    
    private final PanelManager panelManager;
    
    //Initialize all needed panels
    private final LoginPanel loginPanel = new LoginPanel();
    private final OrderOverviewPanel orderOverviewPanel = new OrderOverviewPanel();
    private final CreateSaleOrderPanel createSaleOrderPanel = new CreateSaleOrderPanel();
    
    public static final String LOGIN_PANEL = "Login";
    public static final String ORDER_OVERVIEW_PANEL = "Salesperson Order Overview";
    public static final String CREATE_SALE_ORDER_PANEL = "Saleperson Create Order";
    
    private HashMap<String, JPanel> subPanels;
    
    public SystemPanel () throws ParseException, InterruptedException, IOException{
        
        setLayout(new CardLayout());
        
        subPanels = new HashMap<>();
        subPanels.put(LOGIN_PANEL, loginPanel);
        subPanels.put(ORDER_OVERVIEW_PANEL, orderOverviewPanel);
        subPanels.put(CREATE_SALE_ORDER_PANEL, createSaleOrderPanel);
        
        panelManager = new PanelManager(this, subPanels);
        
        //Setting initial panel
        PanelManager.showPanel(ORDER_OVERVIEW_PANEL);
        
        //Defining a method to set panel size since windows takes task bar into consideration for size
        setPanelSize();
        
    }

    private void setPanelSize() {
        
        //JPanel only accepts dimension
        Dimension size = new Dimension(SYSTEM_WIDTH, SYSTEM_HEIGHT); 
        
        setPreferredSize(size);
        
    }
    
}
