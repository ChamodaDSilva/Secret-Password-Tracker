package com.example.calculator;

public class Item {
    private int id;
    private String description, userName, password;

    public Item() {

    }

    public Item(String description, String userName, String password) {
        this.description = description;
        this.userName = userName;
        this.password = password;
    }

    public Item(int id, String description, String userName, String password) {
        this.id = id;
        this.description = description;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
