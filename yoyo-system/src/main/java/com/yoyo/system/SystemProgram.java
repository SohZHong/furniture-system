package com.yoyo.system;

import com.yoyo.common.ui.UI;
import java.io.IOException;
import java.text.ParseException;

public class SystemProgram {

    private final UI ui;
    private final SystemWindow systemWindow;
    
    public SystemProgram() throws ParseException, InterruptedException, IOException {
        
        ui = new UI();
        
        ui.loadUI();
        
        systemWindow = new SystemWindow();
        
    }

}
