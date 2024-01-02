
package com.yoyo.services.manager;

import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class PanelManager {
    
    private static JPanel mainPanel;
    private static HashMap<String, JPanel> subPanels;
    private static CardLayout layout;
    
    private static String prevPanel, curPanel;
    
    public PanelManager(JPanel mainPanel, HashMap<String, JPanel> subPanels) throws ParseException, InterruptedException, IOException{
        this.mainPanel = mainPanel;
        this.subPanels = subPanels;
        //get parent panel layout as card
        this.layout = (CardLayout) mainPanel.getLayout();
        
        // Adding them all to card layout
        addPanels(subPanels);
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
    
    // Update subPanels dynamically
    public void updateSubPanels(HashMap<String, JPanel> newSubPanels) {
        // Remove existing panels
        for (JPanel panel : subPanels.values()) {
            mainPanel.remove(panel);
        }

        // Update subPanels with new panels
        subPanels = newSubPanels;

        addPanels(subPanels);

        // Repaint the main panel to reflect the changes
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void addPanels(HashMap<String, JPanel> subPanels){
        for (Map.Entry<String, JPanel> entry : subPanels.entrySet()) {
            String panelName = entry.getKey();
            JPanel panel = entry.getValue();
            mainPanel.add(panel, panelName);
        }
    }
}