package com.app.wecare.model;



/*
 * EmployeeRank Class
 * ----------------
 * This class is used to create the EmployeeRank object
 * You can rank one employer
 */

import java.util.Date;

public class EmployeeRank {

    // fields
    private int id;
    private int employeeId;
    private int rank;
    private String date;

    // constructor
    public EmployeeRank(int id, int employeeId, int rank, String date) {
        this.id = id;
        this.employeeId = employeeId;
        this.rank = rank;
        this.date = date;
    }

    public EmployeeRank() {
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

    // set employeeId field
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // get employeeId field
    public int getEmployeeId() {
        return employeeId;
    }

    // set rank field
    public void setRank(int rank) {
        this.rank = rank;
    }

    // get rank field
    public int getRank() {
        return rank;
    }

    // set date field
    public void setDate(String date) {
        this.date = date;
    }

    // get date field
    public String getDate() {
        return date;
    }

}
