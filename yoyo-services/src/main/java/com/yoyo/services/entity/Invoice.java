package com.yoyo.services.entity;

import com.yoyo.common.constant.StatusConstants;

public class Invoice {
    private String invoiceNo;
    private Double totalPrice;
    private String salesPersonName;
    private String customerName;
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

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void copyFrom(Invoice other) {
        this.setInvoiceNo(other.getInvoiceNo());
        this.setTotalPrice(other.getTotalPrice());
        this.setSalesPersonName(other.getSalesPersonName());
        this.setCustomerName(other.getCustomerName());
        this.setStatus(other.getStatus());
    }
}
