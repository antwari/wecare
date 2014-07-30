package com.app.wecare.model;

public class EmplayeeRole {
    // fields
    private int id;
    private String role;

    // constructor
    public EmplayeeRole(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public EmplayeeRole() {
        // will be used before we set our data
    }

    // set id field
    public void setId(int id) {
        this.id = id;
    }

    // get id field
    public int getId() {
        return id;
    }

    // set role field
    public void setRole(String role) {
        this.role = role;
    }

    // get role field
    public String getRole() {
        return role;
    }
}
