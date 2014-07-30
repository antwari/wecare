package com.app.wecare.model;



/*
 * BusinessRank Class
 * ----------------
 * This class is used to create the BusinessRank object
 * You can rank a business , the whole business  in general
 */

public class BusinessRank {
    // fields
    private int id;
    private int rank;
    private String date;

    // constructor
    public BusinessRank(int id, int rank, String date) {
        this.id = id;
        this.rank = rank;
        this.date = date;
    }

    public BusinessRank() {
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
