package com.yoyo.system;

import static com.yoyo.common.constant.SystemConstants.*;
import com.yoyo.services.manager.PanelManager;
import com.yoyo.system.gui.LoginPanel;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JPanel;

public class SystemPanel extends JPanel{
    
    private final PanelManager panelManager;
    
    //Initialize all needed panels
    private final LoginPanel loginPanel = new LoginPanel();
    
    private ArrayList<JPanel> subPanels;
    
    public SystemPanel () throws ParseException, InterruptedException, IOException{
        
        setLayout(new CardLayout());
        
        subPanels = new ArrayList<>();
        subPanels.add(loginPanel);
        
        panelManager = new PanelManager(this, subPanels);
        
        //Setting initial panel
        panelManager.showPanel(loginPanel.getName());
        
        //Defining a method to set panel size since windows takes task bar into consideration for size
        setPanelSize();
        
    }

    private void setPanelSize() {
        
        //JPanel only accepts dimension
        Dimension size = new Dimension(SYSTEM_WIDTH, SYSTEM_HEIGHT); 
        
        setPreferredSize(size);
        
    }
    
}
