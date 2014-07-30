package com.app.wecare.model;

import android.graphics.Bitmap;


public class EmployeeImage {

    // fields
    private int id;
    private Bitmap image;

    // constructor
    public EmployeeImage(int id, Bitmap image) {
        this.id = id;
        this.image = image;
    }

    public EmployeeImage() {
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

    // set image field
    public void setImage(Bitmap image) {
        this.image = image;
    }

    // get image field
    public Bitmap getImage() {
        return image;
    }
}
