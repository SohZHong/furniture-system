package com.yoyo.services.entity;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public abstract class Report {
    
    protected JTable table;
    protected boolean hasRowSorter;
    
    public Report (JTable table){
        this.table = table;
        this.hasRowSorter = table.getRowSorter() != null;
    }
    
    protected String selectFilePath(){
        String path = "";

        JFileChooser j = new JFileChooser();

        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(null);
        if (x == JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        
        return path;
    };
    
    protected abstract PdfPTable createPdfTable();
    
    protected void generatePDFOverview(String fileName) {
        Document doc = new Document();
        try {
            String path = selectFilePath();
            PdfWriter.getInstance(doc, new FileOutputStream(path + File.separator + fileName + ".pdf")).setPageEvent(new PdfPageEventHelper() {
                @Override
                public void onStartPage(PdfWriter writer, Document document) {
                    ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Report"), 290, 820, 0);
                }

                @Override
                public void onEndPage(PdfWriter writer, Document document) {
                    ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Page " + document.getPageNumber()), 550, 30, 0);
                }
            });
            doc.open();
            PdfPTable pdfTable = createPdfTable();
            doc.add(pdfTable);

            JOptionPane.showMessageDialog(null, "The Report Has Been Generated");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        } finally {
            doc.close();
        }
    }
}

