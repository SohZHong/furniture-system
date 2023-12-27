package com.yoyo.services.entity;

import com.yoyo.common.constant.StatusConstants;
import com.yoyo.common.utils.DateTimeUtils;

public class Order {
    private int quantity;
    private Long itemCode;
    private String salesPersonName;
    private String customerName;
    private Double unitPrice;
    private String creationDate;
    private String status;

    public Order(int quantity, Long itemCode, String salesPersonName, String customerName, Double unitPrice) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.salesPersonName = salesPersonName;
        this.customerName = customerName;
        this.unitPrice = unitPrice;
        this.creationDate = DateTimeUtils.getLocalDate();
        this.status = StatusConstants.PENDING_ORDER;
    }

    public Order(int quantity, Long itemCode, String salesPersonName, String customerName, Double unitPrice, String creationDate, String status) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.salesPersonName = salesPersonName;
        this.customerName = customerName;
        this.unitPrice = unitPrice;
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
        return unitPrice * quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void copyFrom(Order other) {
        this.setQuantity(other.getQuantity());
        this.setItemCode(other.getItemCode());
        this.setSalesPersonName(other.getSalesPersonName());
        this.setCustomerName(other.getCustomerName());
        this.setUnitPrice(other.getUnitPrice());
        this.setCreationDate(other.getCreationDate());
        this.setStatus(other.getStatus());
    }
}
