package com.yoyo.services.entity;

import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JTable;

public class OrderReport extends Report{

    public OrderReport(JTable table) {
        super(table);
    }

    @Override
    protected PdfPTable createPdfTable(){
        PdfPTable pdfTable = new PdfPTable(7);
        pdfTable.addCell("Quantity");
        pdfTable.addCell("Item Code");
        pdfTable.addCell("SalesPerson");
        pdfTable.addCell("Unit Price");
        pdfTable.addCell("Total Price");
        pdfTable.addCell("Creation Date");
        pdfTable.addCell("Status");
        
        int iteration = super.hasRowSorter ? 
                super.table.getRowSorter().getModelRowCount() : 
                super.table.getRowCount();
        
        for(int i = 0; i < iteration; i++){
            for(int z = 0; z < 7; z++){
                pdfTable.addCell(
                    super.hasRowSorter ?
                        super.table.getRowSorter().getModel().getValueAt(i, z).toString() :
                        super.table.getValueAt(i, z).toString()
                );
            }
        }
        return pdfTable;
    }
    
    public void generateReport(){
        generatePDFOverview("Order Report");
    }
}
