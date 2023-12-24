package com.yoyo.services.manager;

import com.yoyo.common.utils.ExcelUtils;
import com.yoyo.services.entity.Furniture;
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
    
    public void loadBookings() throws IOException{
        //Load Contents into array
        is = new FileInputStream("C:\\Users\\User\\Desktop\\APU\\Degree Year 2 Sem 1\\Object Oriented Development with Java\\Assignment\\furniture-system\\yoyo-system\\src\\main\\resources\\IKEA_SA_Furniture_Web_Scrapings_sss.csv");
        
        lines = ExcelUtils.readCsvAndProcessRecords(is, entity -> {
            furnitures.add(entity);
        }, record -> {
            return new Furniture(Long.parseLong(record[1]), record[2], record[3], Double.parseDouble(record[4]), record[9]);
        });
        
        // Setting initial capacity for the array list for memory optimization
        furnitures.ensureCapacity(lines);
    }
    
    public ArrayList<Furniture> getFurnitures(){
      return furnitures;
    }
}
