package com.yoyo.services.entity;

import com.yoyo.common.utils.DateTimeUtils;

public class Order {
    private int quantity;
    private Long itemCode;
    private String salesPersonName;
    private String customerName;
    private Double totalPrice;
    private String creationDate;
    private boolean status;

    public Order(int quantity, Long itemCode, String salesPersonName, String customerName, Double totalPrice) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.salesPersonName = salesPersonName;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.creationDate = DateTimeUtils.getLocalDate();
        this.status = false;
    }

    public Order(int quantity, Long itemCode, String salesPersonName, String customerName, Double totalPrice, String creationDate, boolean status) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.salesPersonName = salesPersonName;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.status = status;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void copyFrom(Order other) {
        this.setQuantity(other.getQuantity());
        this.setItemCode(other.getItemCode());
        this.setSalesPersonName(other.getSalesPersonName());
        this.setCustomerName(other.getCustomerName());
        this.setTotalPrice(other.getTotalPrice());
        this.setCreationDate(other.getCreationDate());
        this.setStatus(other.isStatus());
    }
}