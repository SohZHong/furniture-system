package com.yoyo.services.entity;

public class Invoice {
    private final String invoiceNo;
    private final Long totalPrice;
    private final String salesPersonName;
    private boolean status;

    public Invoice(String invoiceNo, Long totalPrice, String salesPersonName) {
        this.invoiceNo = invoiceNo;
        this.totalPrice = totalPrice;
        this.salesPersonName = salesPersonName;
        this.status = false;
    }
    
    public Invoice(String invoiceNo, Long totalPrice, String salesPersonName, boolean status) {
        this.invoiceNo = invoiceNo;
        this.totalPrice = totalPrice;
        this.salesPersonName = salesPersonName;
        this.status = status;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
