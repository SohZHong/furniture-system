package com.yoyo.common.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.UIManager;

public class UI {
    
    private static final Color backgroundColor = new Color(255, 233, 221);
    private static final Color inputBackgroundColor = new Color(255, 255, 255);
    private static final Color buttonColor = new Color(240, 207, 189);
    private static final Color fontColor = new Color(41, 41, 41);
            
    private static final Font mainFont = new Font("Martel Sans", Font.BOLD, 36);
    private static final Font inputFont = new Font("Martel Sans", Font.BOLD, 30);
    private static final Font buttonFont = new Font("STXihei", Font.BOLD, 30);
    
    
    public final void loadUI(){
        try{
            //Setting Windows Native look to UI
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        UIManager.getLookAndFeelDefaults().put("Panel.background", backgroundColor);
        
        UIManager.getLookAndFeelDefaults().put("Label.font", mainFont);
        
        UIManager.getLookAndFeelDefaults().put("Button.font", buttonFont);
        UIManager.getLookAndFeelDefaults().put("Button.border", backgroundColor);
        UIManager.getLookAndFeelDefaults().put("Button.background", buttonColor);
        UIManager.getLookAndFeelDefaults().put("Button.highlight", buttonColor.brighter());
        UIManager.getLookAndFeelDefaults().put("Button.light", buttonColor.brighter().brighter());
        UIManager.getLookAndFeelDefaults().put("Button.shadow", buttonColor.brighter());
        UIManager.getLookAndFeelDefaults().put("Button.darkShadow", buttonColor.darker().darker());

        UIManager.getLookAndFeelDefaults().put("TextField.background", inputBackgroundColor);
        UIManager.getLookAndFeelDefaults().put("TextField.font", inputFont);
        UIManager.getLookAndFeelDefaults().put("TextField.foreground", fontColor); 
        UIManager.getLookAndFeelDefaults().put("TextField.margin", new Insets(0, 2, 0, 2));
        UIManager.getLookAndFeelDefaults().put("TextField.padding", new Insets(0, 2, 0, 2));
        
        UIManager.getLookAndFeelDefaults().put("Table.font", inputFont);
        UIManager.getLookAndFeelDefaults().put("Table.foreground", fontColor);
        UIManager.getLookAndFeelDefaults().put("TableHeader.font", inputFont);
        UIManager.getLookAndFeelDefaults().put("TableHeader.foreground", fontColor);


    }
    
}
