package com.example.prometheus;

public class User {
    private String name;
    private String email;
    private String idNumber;
    private String phoneNumber;

    public User() {
        // Default constructor required for Firebase
    }

    public User(String name, String email, String idNumber, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
