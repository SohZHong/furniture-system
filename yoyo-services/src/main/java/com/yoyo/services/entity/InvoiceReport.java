package com.yoyo.services.entity;

import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JTable;

public class InvoiceReport extends Report{
    public InvoiceReport(JTable table) {
        super(table);
    }

    @Override
    protected PdfPTable createPdfTable() {
        PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.addCell("Invoice ID");
            pdfTable.addCell("Total Price");
            pdfTable.addCell("SalesPerson");
            pdfTable.addCell("Customer Name");
            pdfTable.addCell("Status");

        int iteration = super.hasRowSorter ?
                super.table.getRowSorter().getModelRowCount() :
                super.table.getRowCount();

        for (int i = 0; i < iteration; i++) {
            for (int z = 0; z < super.table.getColumnCount(); z++) {
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
        generatePDFOverview("Invoice Report");
    }
}
