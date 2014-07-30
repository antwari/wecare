package com.app.wecare.model;

public class BusinessRankComment {
    // fields
    private int id;
    private String name;
    private int businessRankId;

    // constructor
    public BusinessRankComment(int id, String name, int businessRankId) {
        this.id = id;
        this.name = name;
        this.businessRankId = businessRankId;
    }

    public BusinessRankComment() {
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

    // set businessRankId field
    public void setBusinessRankId(int businessRankId) {
        this.businessRankId = businessRankId;
    }

    // get businessRankId field
    public int getBusinessRankId() {
        return businessRankId;
    }
}
