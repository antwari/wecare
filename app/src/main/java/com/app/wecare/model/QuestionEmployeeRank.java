package com.app.wecare.model;

public class QuestionEmployeeRank {
    // fields
    private int id;
    private int questionId;
    private int employeeRankId;

    // constructor
    public QuestionEmployeeRank(int id, int questionId, int employeeRankId) {
        this.id = id;
        this.questionId = questionId;
        this.employeeRankId = employeeRankId;
    }

    public QuestionEmployeeRank() {
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
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    // get questionId field
    public int getQuestionId() {
        return questionId;
    }

    // set usersRankId field
    public void setEmployeeRankId(int employeeRankId) {
        this.employeeRankId = employeeRankId;
    }

    // get usersRankId field
    public int getEmployeeRankId() {
        return employeeRankId;
    }
}
