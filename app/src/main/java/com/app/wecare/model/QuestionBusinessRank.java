package com.app.wecare.model;


public class QuestionBusinessRank {
    // fields
    private int id;
    private int questionId;
    private int businessRankId ;

    // constructor
    public QuestionBusinessRank(int id, int questionId, int businessRankId) {
        this.id = id;
        this.questionId = questionId;
        this.businessRankId = businessRankId;
    }

    public QuestionBusinessRank() {
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

    // set businessRankId field
    public void setBusinessRankId(int businessRankId) {
        this.businessRankId = businessRankId;
    }

    // get businessRankId field
    public int getBusinessRankId() {
        return businessRankId;
    }


}
