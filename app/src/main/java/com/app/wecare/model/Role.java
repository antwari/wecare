package com.app.wecare.model;

/*
 * Role Class
 * ----------------
 * This class is used to create the Role object
 * The role maybe the Manager , the Chief and so on
 */

public class Role {

    // fields
    private int id;
    private String name;
    private String modifiedOn;

    // constructor
    public Role(int id, String name, String modifiedOn) {
        this.id = id;
        this.name = name;
        this.modifiedOn = modifiedOn;
    }

    public Role() {
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
