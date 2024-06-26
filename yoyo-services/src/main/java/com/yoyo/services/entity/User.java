package com.yoyo.services.entity;

public class User {
    private String name;
    private String password;
    private String phoneNumber;
    private String role;


    public User(String name, String password, String phoneNumber, String role) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void copyFrom(User other) {
        this.setName(other.getName());
        this.setPassword(other.getPassword());
        this.setPhoneNumber(other.getPhoneNumber());
        this.setRole(other.getRole());
    }
}