package com.app.wecare.model;

public class EmployeeDepartment {
    // fields
    private int employeeId;
    private String department;

    // constructor
    public EmployeeDepartment(int employeeId, String department) {
        this.employeeId = employeeId;
        this.department = department;
    }

    public EmployeeDepartment() {
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
    public void setDepartment(String department) {
        this.department = department;
    }

    // get role field
    public String getDepartment() {
        return department;
    }
}
