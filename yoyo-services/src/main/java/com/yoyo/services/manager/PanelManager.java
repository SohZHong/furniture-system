
package com.yoyo.services.manager;

import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelManager {
    
    private static JPanel mainPanel;
    private static CardLayout layout;
    
    private static String prevPanel, curPanel;
    
    public PanelManager(JPanel mainPanel, ArrayList<JPanel> subPanels) throws ParseException, InterruptedException, IOException{
        this.mainPanel = mainPanel;
        
        //get parent panel layout as card
        layout = (CardLayout) mainPanel.getLayout();
        
        //Adding them all to cardlayout
        for (JPanel panel : subPanels) {
            mainPanel.add(panel, panel.getName());
        }
    }
    
    //Show panel accepted as argument through cardlayout
    public static void showPanel(String panelName){
        prevPanel = curPanel;
        curPanel = panelName;
        
        layout.show(mainPanel, panelName);
    }
    
    public static void previousPanel(){
        layout.show(mainPanel, prevPanel);
        
        curPanel = prevPanel;
    }
}