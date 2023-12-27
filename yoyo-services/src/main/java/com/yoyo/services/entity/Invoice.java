package com.yoyo.services.entity;

import com.yoyo.common.constant.StatusConstants;

public class Invoice {
    private final String invoiceNo;
    private final Double totalPrice;
    private final String salesPersonName;
    private final String customerName;
    private String status;

    public Invoice(String invoiceNo, Double totalPrice, String salesPersonName, String customerName) {
        this.invoiceNo = invoiceNo;
        this.totalPrice = totalPrice;
        this.salesPersonName = salesPersonName;
        this.customerName = customerName;
        this.status = StatusConstants.INVOICE_IN_PROGRESS;
    }
    
    public Invoice(String invoiceNo, Double totalPrice, String salesPersonName, String customerName, String status) {
        this.invoiceNo = invoiceNo;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.salesPersonName = salesPersonName;
        this.status = status;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
