package com.app.wecare.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.Question;

import java.util.LinkedList;
import java.util.List;

// Question Data access object

public class QuestionDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_QUESTION_ID, MySQLiteHelper.KEY_QUESTION_NAME, MySQLiteHelper.KEY_QUESTION_CATEGORY, MySQLiteHelper.KEY_QUESTION_MODIFIED_ON};
    Context context;


    public QuestionDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
        this.context = context;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
        Log.v("DC", "Database Closed");
    }

    public void addQuestion(int id, String name, int category, String modifiedOn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_QUESTION_ID, id);
        values.put(MySQLiteHelper.KEY_QUESTION_NAME, name);
        values.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, category);
        values.put(MySQLiteHelper.KEY_QUESTION_MODIFIED_ON, modifiedOn);
        database.insert(MySQLiteHelper.TABLE_QUESTION, null, values);

    }

    // put cursor into Question object
    private Question cursorToQuestion(Cursor cursor) {
        Question question = new Question();
        question.setId(cursor.getInt(0));
        question.setName(cursor.getString(1));
        question.setCategory(cursor.getInt(2));
        question.setModifiedOn(cursor.getString(3));
        return question;
    }

    public int updateQuestion(int id, String name, int category, String modifiedOn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_QUESTION_NAME, name);
        values.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, category);
        values.put(MySQLiteHelper.KEY_QUESTION_MODIFIED_ON, modifiedOn);
        int num = database.update(MySQLiteHelper.TABLE_QUESTION, values, MySQLiteHelper.KEY_QUESTION_ID + " = " + id, null);
        return num;
    }

    public void deleteQuestionByQuestionObject(Question question) {
        database.delete(MySQLiteHelper.TABLE_QUESTION, MySQLiteHelper.KEY_QUESTION_ID + " = " + question.getId(), null);

    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new LinkedList<Question>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_QUESTION;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build question and add it to list
        if (cursor.moveToFirst()) {
            do {
                Question question = cursorToQuestion(cursor);
                questions.add(question);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return questions;
    }

    public Question getQuestionById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_QUESTION, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_QUESTION_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        Question question = cursorToQuestion(cursor);
        cursor.close();

        return question;
    }

    public List<Question> getQuestionByCategory(int category) {
        List<Question> questions = new LinkedList<Question>();


        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_QUESTION, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_QUESTION_CATEGORY + " = ?", // c. selections
                        new String[]{String.valueOf(category)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit


        //  go over each row, build department and add it to list


        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Question question = cursorToQuestion(cursor);
            questions.add(question);
        }


        cursor.close();

        Log.d("getQuestionByCategory()", questions.toString());

        return questions;
    }


}
