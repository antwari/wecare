package com.app.wecare.model;


public class EmployeeRole {

    // fields
    private int employeeId;
    private String role;

    // constructor
    public EmployeeRole(int employeeId, String role) {
        this.employeeId = employeeId;
        this.role = role;
    }

    public EmployeeRole() {
        // will be used before we set our data
    }

    // set employeeId field
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // get employeeId field
    public int getEmployeeId() {
        return employeeId;
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
