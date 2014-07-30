package com.app.wecare.model;

/*
 * Department Class
 * ----------------
 * This class is used to create the Department object
 */

public class Department {

    // fields
    private int id;
    private String name;
    private String modifiedOn;

    // constructor
    public Department(int id, String name, String modifiedOn) {
        this.id = id;
        this.name = name;
        this.modifiedOn = modifiedOn;
    }

    public Department() {
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

    // set modifiedOn field
    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    // get modifiedOn field
    public String getModifiedOn() {
        return modifiedOn;
    }

}
