package com.yoyo.system;

import com.yoyo.common.ui.UI;
import java.io.IOException;
import java.text.ParseException;

public class SystemProgram {

    private final UI ui;
    
    //Variables to be called across system
    // Width and height divided by 32 to define image count. E.g. 1280/32 = 40 images wide
    public final static int SYSTEM_HEIGHT = 960;
    public final static int SYSTEM_WIDTH = 1440;
    
    public SystemProgram() throws ParseException, InterruptedException, IOException {
        
        ui = new UI();
        
        ui.loadUI();
        
        new SystemPanel();
        new SystemWindow();
        
    }

}
