package com.app.wecare.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.BusinessRankComment;
import com.app.wecare.model.EmployeeRankComment;

import java.util.LinkedList;
import java.util.List;

// EmployeeRankComment Data access object

public class EmployeeRankCommentDAO {


    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_ID, MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_NAME, MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_EMPLOYEE_RANK_Id};
    Context context;


    public EmployeeRankCommentDAO(Context context) {
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

    public void addEmployeeRankComment(int id, String name, int employeeRankId) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_ID, id);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_NAME, name);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_EMPLOYEE_RANK_Id, employeeRankId);
        database.insert(MySQLiteHelper.TABLE_EMPLOYEE_RANK_COMMENT, null, values);

    }

    // put cursor into EmployeeRankComment object
    private EmployeeRankComment cursorToEmployeeRankComment(Cursor cursor) {

        EmployeeRankComment employeeRankComment = new EmployeeRankComment();
        employeeRankComment.setId(cursor.getInt(0));
        employeeRankComment.setName(cursor.getString(1));
        employeeRankComment.setEmployeeRankId(cursor.getInt(2));

        return employeeRankComment;
    }

    public int updateEmployeeRankComment(int id, String name, int employeeRankId) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_NAME, name);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_EMPLOYEE_RANK_Id, employeeRankId);
        int num = database.update(MySQLiteHelper.TABLE_EMPLOYEE_RANK_COMMENT, values, MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_ID + " = " + id, null);
        return num;
    }

    public void deleteEmployeeRankCommentByObject(EmployeeRankComment employeeRankComment) {
        database.delete(MySQLiteHelper.TABLE_EMPLOYEE_RANK_COMMENT, MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_ID + " = " + employeeRankComment.getId(), null);

    }

    public List<EmployeeRankComment> getAllEmployeeRankComment() {
        List<EmployeeRankComment> employeeRankComments = new LinkedList<EmployeeRankComment>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_EMPLOYEE_RANK_COMMENT;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build question and add it to list
        if (cursor.moveToFirst()) {
            do {
                EmployeeRankComment employeeRankComment = cursorToEmployeeRankComment(cursor);
                employeeRankComments.add(employeeRankComment);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return employeeRankComments;
    }

    public EmployeeRankComment getEmployeeRankCommentById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE_RANK_COMMENT, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        EmployeeRankComment employeeRankComment = cursorToEmployeeRankComment(cursor);
        cursor.close();

        return employeeRankComment;
    }


    public EmployeeRankComment getEmployeeRankCommentByEmployeeRankId(int employeeRankId) {
        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE_RANK_COMMENT, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_EMPLOYEE_RANK_COMMENT_EMPLOYEE_RANK_Id + " = ?", // c. selections
                        new String[]{String.valueOf(employeeRankId)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        EmployeeRankComment employeeRankComment = cursorToEmployeeRankComment(cursor);
        cursor.close();

        return employeeRankComment;
    }


}
