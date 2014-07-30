package com.app.wecare.model;


public class EmployeeRankComment {
    // fields
    private int id;
    private String name;
    private int employeeRankId;

    // constructor
    public EmployeeRankComment(int id, String name, int employeeRankId) {
        this.id = id;
        this.name = name;
        this.employeeRankId = employeeRankId;
    }

    public EmployeeRankComment() {
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

    // set name field
    public void setName(String name) {
        this.name = name;
    }

    // get name field
    public String getName() {
        return name;
    }

    // set employeeRankId field
    public void setEmployeeRankId(int employeeRankId) {
        this.employeeRankId = employeeRankId;
    }

    // get employeeRankId field
    public int getEmployeeRankId() {
        return employeeRankId;
    }
}
