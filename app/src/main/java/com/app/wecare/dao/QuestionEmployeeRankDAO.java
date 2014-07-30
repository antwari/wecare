package com.app.wecare.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.QuestionBusinessRank;
import com.app.wecare.model.QuestionEmployeeRank;

import java.util.LinkedList;
import java.util.List;

// QuestionEmployeeRank Data access object

public class QuestionEmployeeRankDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_ID, MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_QUESTION_ID, MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_EMPLOYEE_RANK_Id};
    Context context;


    public QuestionEmployeeRankDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
        this.context = context;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        // if (database != null && database.isOpen())
        dbHelper.close();
        Log.v("DC", "Database Closed");
    }

    public void addQuestionEmployeeRank(int id, int questionId, int employeeRankId) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_ID, id);
        values.put(MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_QUESTION_ID, questionId);
        values.put(MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_EMPLOYEE_RANK_Id, employeeRankId);

        database.insert(MySQLiteHelper.TABLE_QUESTION_EMPLOYEE_RANK, null, values);

    }

    // put cursor to QuestionEmployeeRank object
    private QuestionEmployeeRank cursorToQuestionEmployeeRank(Cursor cursor) {

        QuestionEmployeeRank questionEmployeeRank = new QuestionEmployeeRank();
        questionEmployeeRank.setId(cursor.getInt(0));
        questionEmployeeRank.setQuestionId(cursor.getInt(1));
        questionEmployeeRank.setEmployeeRankId(cursor.getInt(2));

        return questionEmployeeRank;
    }

    // update TABLE_QUESTION_EMPLOYEE_RANK
    public int updateQuestionEmployeeRank(int id, int questionId, int employeeRankId) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_QUESTION_ID, questionId);
        values.put(MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_EMPLOYEE_RANK_Id, employeeRankId);
        int num = database.update(MySQLiteHelper.TABLE_QUESTION_EMPLOYEE_RANK, values, MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_ID + " = " + id, null);
        return num;
    }

    // delete QuestionEmployeeRank object
    public void deleteQuestionEmployeeRankByObject(QuestionEmployeeRank questionEmployeeRank) {
        database.delete(MySQLiteHelper.TABLE_QUESTION_EMPLOYEE_RANK, MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_ID + " = " + questionEmployeeRank.getId(), null);

    }

    // get All questionEmployeeRank
    public List<QuestionEmployeeRank> getAllQuestionEmployeeRank() {
        List<QuestionEmployeeRank> questionEmployeeRanks = new LinkedList<QuestionEmployeeRank>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_QUESTION_EMPLOYEE_RANK;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build question and add it to list
        if (cursor.moveToFirst()) {
            do {
                QuestionEmployeeRank questionEmployeeRank = cursorToQuestionEmployeeRank(cursor);
                questionEmployeeRanks.add(questionEmployeeRank);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return questionEmployeeRanks;
    }

    public QuestionEmployeeRank getQuestionEmployeeRankById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_QUESTION_EMPLOYEE_RANK, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_QUESTION_EMPLOYEE_RANK_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        QuestionEmployeeRank questionEmployeeRank = cursorToQuestionEmployeeRank(cursor);

        cursor.close();
        // return role
        return questionEmployeeRank;
    }

}
