package com.app.wecare.model;

/*
 * Employee Class
 * ----------------
 * This class is used to create the Employee object
 */

public class Employee {

    // variable declaration
    private int id;
    private int departmentId;
    private String numberAssigned;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private int roleId;
    private String imgName;
    private int status;
    private String modifiedOn;

    public Employee() {
        // will be used before we set our data
    }

    // Employee constructor
    /*
     * it sets all its properties
	 */
    public Employee(int id, int departmentId, String numberAssigned,
                    String firstName, String lastName, String email, String password,
                    String phoneNumber, int roleId, int status, String imgName,
                    String modifiedOn) {
        this.id = id;
        this.departmentId = departmentId;
        this.numberAssigned = numberAssigned;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
        this.status = status;
        this.imgName = imgName;
        this.modifiedOn = modifiedOn;
    }

    // set id method
    public void setId(int id) {
        this.id = id;
    }

    // get id method
    public int getId() {
        return id;
    }

    // set departmentId method
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // get departmentId method
    public int getDepartmentId() {
        return departmentId;
    }

    // set numberAssigned method
    public void setNumberAssigned(String numberAssigned) {
        this.numberAssigned = numberAssigned;
    }

    // get numberAssigned method
    public String getNumberAssigned() {
        return numberAssigned;
    }

    // set firstName method
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // get firstName method
    public String getFirstName() {
        return firstName;
    }

    // set lastName method
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // get lastName method
    public String getLastName() {
        return lastName;
    }

    // set email method
    public void setEmail(String email) {
        this.email = email;
    }

    // get email method
    public String getEmail() {
        return email;
    }

    // set password method
    public void setPassword(String password) {
        this.password = password;
    }

    // get password method
    public String getPassword() {
        return password;
    }

    // set phoneNumber method
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // get phoneNumber method
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // set roleId method
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    // get roleId method
    public int getRoleId() {
        return roleId;
    }

    // set status method (if status = 0 he is an employee else if status == 1 he is an administrator)
    public void setStatus(int status) {
        this.status = status;
    }

    // get status method (if status = 0 he is an employee else if status == 1 he is an administrator)
    public int getStatus() {
        return status;
    }

    // set imgName method
    public void setImageName(String imgName) {
        this.imgName = imgName;
    }

    // get imgName method
    public String getImageName() {
        return imgName;
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
