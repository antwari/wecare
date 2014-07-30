package com.app.wecare.dao;

// BusinessRankComment Data access object

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.BusinessRankComment;

import java.util.LinkedList;
import java.util.List;

public class BusinessRankCommentDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_ID, MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_NAME, MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_BUSINESS_RANK_Id};
    Context context;


    public BusinessRankCommentDAO(Context context) {
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

    public void addBusinessRankComment(int id, String name, int businessRankId) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_ID, id);
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_NAME, name);
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_BUSINESS_RANK_Id, businessRankId);
        database.insert(MySQLiteHelper.TABLE_BUSINESS_RANK_COMMENT, null, values);

    }

    // put cursor into BusinessRankComment object
    private BusinessRankComment cursorToBusinessRankComment(Cursor cursor) {

        BusinessRankComment businessRankComment = new BusinessRankComment();
        businessRankComment.setId(cursor.getInt(0));
        businessRankComment.setName(cursor.getString(1));
        businessRankComment.setBusinessRankId(cursor.getInt(2));

        return businessRankComment;
    }

    public int updateBusinessRankComment(int id, String name, int businessRankId) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_NAME, name);
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_BUSINESS_RANK_Id, businessRankId);
        int num = database.update(MySQLiteHelper.TABLE_BUSINESS_RANK_COMMENT, values, MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_ID + " = " + id, null);
        return num;
    }

    public void deleteBusinessRankCommentByObject(BusinessRankComment businessRankComment) {
        database.delete(MySQLiteHelper.TABLE_BUSINESS_RANK_COMMENT, MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_ID + " = " + businessRankComment.getId(), null);

    }

    public List<BusinessRankComment> getAllBusinessRankComment() {
        List<BusinessRankComment> businessRankComments = new LinkedList<BusinessRankComment>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_BUSINESS_RANK_COMMENT;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build BusinessRankComment object and add it to list
        if (cursor.moveToFirst()) {
            do {
                BusinessRankComment businessRankComment = cursorToBusinessRankComment(cursor);
                businessRankComments.add(businessRankComment);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return businessRankComments;
    }

    public BusinessRankComment getBusinessRankCommentsById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_BUSINESS_RANK_COMMENT, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        BusinessRankComment businessRankComment = cursorToBusinessRankComment(cursor);

        cursor.close();

        return businessRankComment;
    }

    public BusinessRankComment getBusinessRankCommentByBusinessRankId(int businessRankId) {
        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_BUSINESS_RANK_COMMENT, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_BUSINESS_RANK_COMMENT_BUSINESS_RANK_Id + " = ?", // c. selections
                        new String[]{String.valueOf(businessRankId)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        BusinessRankComment businessRankComment = cursorToBusinessRankComment(cursor);
        cursor.close();


        return businessRankComment;


    }
}
