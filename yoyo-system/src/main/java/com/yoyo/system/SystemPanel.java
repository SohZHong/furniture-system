package com.yoyo.system;

import static com.yoyo.system.SystemProgram.*;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JPanel;

public class SystemPanel extends JPanel{
    
    public SystemPanel () throws ParseException, InterruptedException, IOException{
        
        
        setLayout(new CardLayout());
        
//        panelManager = new PanelManager(this);
//        
//        //Setting initial panel
//        panelManager.showPanel(PanelManager.LOGIN_PANEL);
        
        //Defining a method to set panel size since windows takes task bar into consideration for size
        setPanelSize();
        
    }

    private void setPanelSize() {
        
        //JPanel only accepts dimension
        Dimension size = new Dimension(SYSTEM_WIDTH, SYSTEM_HEIGHT); 
        
        setPreferredSize(size);
        
    }
    
}
