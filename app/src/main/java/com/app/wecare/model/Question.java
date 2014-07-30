package com.app.wecare.model;

public class Question {
    // fields
    private int id;
    private String name;
    /*
    In Employee
    -----------
    category 0 for poor rank , 1 for average rank and 2  for good rank


    In Business
    -----------
     category 3 for poor rank , 4 for average rank and 5 for good rank
     */
    private int category;
    private String modifiedOn;

    // constructor
    public Question(int id, String name, int category, String modifiedOn) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.modifiedOn = modifiedOn;
    }

    public Question() {
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

    // set category field
    public void setCategory(int category) {
        this.category = category;
    }

    // get category field
    public int getCategory() {
        return category;
    }

    // set modifiedOn method
    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    // get modifiedOn method
    public String getModifiedOn() {
        return modifiedOn;
    }
}
