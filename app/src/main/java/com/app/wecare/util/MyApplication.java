package com.app.wecare.util;

import android.app.Application;


public class MyApplication extends Application {

    private int departmentId;
    private boolean goToRAnkActivity;
    private int employeeId;
    private String employeeAssignedNumber;
    private int rank;
    private int questionCategory;


    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean getGoToRAnkActivity() {
        return goToRAnkActivity;
    }

    public void setGoToRAnkActivity(boolean goToRAnkActivity) {
        this.goToRAnkActivity = goToRAnkActivity;
    }

    public String getEmployeeAssignedNumber() {
        return employeeAssignedNumber;
    }

    public void setEmployeeAssignedNumber(String employeeAssignedNumber) {
        this.employeeAssignedNumber = employeeAssignedNumber;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setQuestionCategory(int questionCategory) {
        this.questionCategory = questionCategory;
    }

    public int getQuestionCategory() {
        return questionCategory;
    }

}
