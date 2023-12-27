package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.common.utils.ExcelUtils;
import com.yoyo.services.entity.Furniture;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FurnitureManager {
    private FileInputStream is;
    private ArrayList<Furniture> furnitures;
    private int lines;
    
    public FurnitureManager(){
        furnitures = new ArrayList<>();
    }
    
    public void loadFurnitures() throws IOException{
        //Load Contents into array
        is = new FileInputStream(DataConstants.ASSET_FOLDER + File.separator + DataConstants.FURNITURE_FILE);
        
        lines = ExcelUtils.readCsvAndProcessRecords(is, entity -> {
            furnitures.add(entity);
        }, record -> {
            return new Furniture(Long.valueOf(record[1]), record[2], record[3], Double.valueOf(record[4]), record[9]);
        });
        
        // Setting initial capacity for the array list for memory optimization
        furnitures.ensureCapacity(lines);
    }
    
    public ArrayList<Furniture> getFurnitures(){
      return furnitures;
    }
}
