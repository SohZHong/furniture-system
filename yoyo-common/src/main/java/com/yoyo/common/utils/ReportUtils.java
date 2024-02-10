/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoyo.common.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Acer
 */
public class ReportUtils {
    public void OrderOverview(JTable table){
        String path = "";

        JFileChooser j = new JFileChooser();

        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(null);
        if (x == JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try{
            PDFHeaderFooterUtils event = new PDFHeaderFooterUtils();
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf")).setPageEvent(event);
            doc.open();



            PdfPTable tb1 = new PdfPTable(7);
            tb1.addCell("Invoice ID");
            tb1.addCell("Item Code");
            tb1.addCell("SalesPerson");
            tb1.addCell("Unit Price");
            tb1.addCell("Total Price");
            tb1.addCell("Creation Date");
            tb1.addCell("Status");

            for(int i = 0; i < table.getRowCount(); i++){

                for(int z = 0; z < 7; z++){
                    String value = table.getValueAt(i, z).toString();
                    tb1.addCell(value);
                }
            }
            doc.add(tb1);
            JOptionPane.showMessageDialog(null,"The Report Has Been Generated");
        } catch (DocumentException | HeadlessException | FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong");
        }
        doc.close();
    }
    
    public void InvoiceOverview(JTable table){
        String path = "";

        JFileChooser j = new JFileChooser();

        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(null);
        if (x == JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try{
            PDFHeaderFooterUtils event = new PDFHeaderFooterUtils();
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf")).setPageEvent(event);
            doc.open();



            PdfPTable tb1 = new PdfPTable(5);
            tb1.addCell("Invoice ID");
            tb1.addCell("Total Price");
            tb1.addCell("SalesPerson");
            tb1.addCell("Customer Name");
            tb1.addCell("Status");

            for(int i = 0; i < table.getRowCount(); i++){

                for(int z = 0; z < 5; z++){
                    String value = table.getValueAt(i, z).toString();
                    tb1.addCell(value);
                }
            }
            doc.add(tb1);
            JOptionPane.showMessageDialog(null,"The Report Has Been Generated");
        } catch (DocumentException | HeadlessException | FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong");
        }
        doc.close();
    }

    public static class PDFHeaderFooterUtils extends PdfPageEventHelper {

        public void onStartPage(PdfWriter writer, Document document) {
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Report"), 290, 820, 0);
        }

        public void onEndPage(PdfWriter writer, Document document) {
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Page " + document.getPageNumber()), 550, 30, 0);
        }

    }
}
