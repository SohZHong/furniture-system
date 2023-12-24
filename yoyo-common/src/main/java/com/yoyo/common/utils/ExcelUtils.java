package com.yoyo.common.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;

public class ExcelUtils {
    public interface RecordMapper<T> {
        T mapRecord(String[] record);
    }
    
    public static DefaultTableModel readCsvAndCreateTableModel(InputStream inputStream) {
        DefaultTableModel model = null;
        // Read CSV file
         try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            List<String[]> rows = reader.readAll();

            // Assuming the first row contains column headers
            String[] headers = rows.get(0);
            model = new DefaultTableModel(headers, 0);

            // Populate the table model
            for (int i = 1; i < rows.size(); i++) {
                model.addRow(rows.get(i));
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return model;
    }
    
    // Stream approach-based function to reduce performance overhead
    public static <T> int readCsvAndProcessRecords(InputStream inputStream, Consumer<T> recordProcessor, RecordMapper<T> recordMapper) {
        int recordCount = 0;
        // Read CSV file using a streaming approach
        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            List<String[]> rows = reader.readAll();

            // Skip the header row and process each record
            for (int i = 1; i < rows.size(); i++) {
                String[] record = rows.get(i);

                // Map the String[] record to an instance of type T using the provided RecordMapper
                T mappedRecord = recordMapper.mapRecord(record);

                // Process the record
                recordProcessor.accept(mappedRecord);
                
                // Increment the record count for setting list initial capacity
                recordCount++;
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        
        return recordCount;
    }
}
