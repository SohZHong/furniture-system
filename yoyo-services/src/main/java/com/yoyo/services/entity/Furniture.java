package com.yoyo.services.entity;

public class Furniture {
    private final Long id;
    private final String name;
    private final String category; 
    private final Double price;
    private final String description;

    public Furniture(Long id, String name, String category, Double price, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
