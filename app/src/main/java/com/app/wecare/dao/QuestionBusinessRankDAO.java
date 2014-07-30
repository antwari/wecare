package com.app.wecare.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.QuestionBusinessRank;

import java.util.LinkedList;
import java.util.List;

// QuestionBusinessRank Data access object

public class QuestionBusinessRankDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_ID, MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_QUESTION_ID, MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_BUSINESS_RANK_Id};
    Context context;


    public QuestionBusinessRankDAO(Context context) {
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

    public void addQuestionBusinessRank(int id, int questionId, int businessRankId) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_ID, id);
        values.put(MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_QUESTION_ID, questionId);
        values.put(MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_BUSINESS_RANK_Id, businessRankId);

        database.insert(MySQLiteHelper.TABLE_QUESTION_BUSINESS_RANK, null, values);

    }

    // put cursor to QuestionBusinessRank object
    private QuestionBusinessRank cursorToQuestionBusinessRank(Cursor cursor) {

        QuestionBusinessRank questionBusinessRank = new QuestionBusinessRank();
        questionBusinessRank.setId(cursor.getInt(0));
        questionBusinessRank.setQuestionId(cursor.getInt(1));
        questionBusinessRank.setBusinessRankId(cursor.getInt(2));

        return questionBusinessRank;
    }

    // update TABLE_QUESTION_BUSINESS_RANK
    public int updateQuestionBusinessRank(int id, int questionId, int businessRankId) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_QUESTION_ID, questionId);
        values.put(MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_BUSINESS_RANK_Id, businessRankId);
        int num = database.update(MySQLiteHelper.TABLE_QUESTION_BUSINESS_RANK, values, MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_ID + " = " + id, null);
        return num;
    }

    // delete QuestionBusinessRank object
    public void deleteQuestionBusinessRankByObject(QuestionBusinessRank questionBusinessRank) {
        database.delete(MySQLiteHelper.TABLE_QUESTION_BUSINESS_RANK, MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_ID + " = " + questionBusinessRank.getId(), null);

    }

    // get All questionBusinessRank
    public List<QuestionBusinessRank> getAllQuestionBusinessRank() {
        List<QuestionBusinessRank> questionBusinessRanks = new LinkedList<QuestionBusinessRank>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_QUESTION_BUSINESS_RANK;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build question and add it to list
        if (cursor.moveToFirst()) {
            do {
                QuestionBusinessRank questionBusinessRank = cursorToQuestionBusinessRank(cursor);
                questionBusinessRanks.add(questionBusinessRank);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return questionBusinessRanks;
    }

    public QuestionBusinessRank getQuestionBusinessRankById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_QUESTION_BUSINESS_RANK, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_QUESTION_BUSINESS_RANK_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        QuestionBusinessRank questionBusinessRank = cursorToQuestionBusinessRank(cursor);

        cursor.close();
        // return role
        return questionBusinessRank;
    }


}
