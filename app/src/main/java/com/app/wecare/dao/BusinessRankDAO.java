package com.app.wecare.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.BusinessRank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// BusinessRank Data access object

public class BusinessRankDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_BUSINESS_RANK_ID, MySQLiteHelper.KEY_BUSINESS_RANK_RANK, MySQLiteHelper.KEY_BUSINESS_RANK_DATE};
    Context context;


    public BusinessRankDAO(Context context) {
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

    public void addBusinessRank(int rank) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_RANK, rank);

        // getting the current time and date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

        Date date = new Date();
        String currentDateTime = dateFormat.format(date);

        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_DATE, currentDateTime);
        database.insert(MySQLiteHelper.TABLE_BUSINESS_RANK, null, values);

    }

    // put cursor into BusinessRank object
    private BusinessRank cursorToBusinessRank(Cursor cursor) {

        BusinessRank item = new BusinessRank();
        item.setId(cursor.getInt(0));
        item.setRank(cursor.getInt(1));
        item.setDate(cursor.getString(2));
        return item;

    }

    public int updateBusinessRank(int id, int rank, String date) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_RANK, rank);
        values.put(MySQLiteHelper.KEY_BUSINESS_RANK_DATE, date);
        int num = database.update(MySQLiteHelper.TABLE_BUSINESS_RANK, values, MySQLiteHelper.KEY_BUSINESS_RANK_ID + " = " + id, null);
        return num;
    }


    public void deleteBusinessRankByBusinessRankObject(BusinessRank businessRank) {
        database.delete(MySQLiteHelper.TABLE_BUSINESS_RANK, MySQLiteHelper.KEY_BUSINESS_RANK_ID + " = " + businessRank.getId(), null);

    }

    public List<BusinessRank> getAllBusinessRank() {
        List<BusinessRank> businessRanks = new LinkedList<BusinessRank>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_BUSINESS_RANK;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build BusinessRank and add it to list
        if (cursor.moveToFirst()) {
            do {
                BusinessRank businessRank = cursorToBusinessRank(cursor);
                businessRanks.add(businessRank);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return businessRanks;
    }

    public BusinessRank getBusinessRankById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_BUSINESS_RANK, // a. table
                        allColumns, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //  if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();


        BusinessRank businessRank = cursorToBusinessRank(cursor);

        cursor.close();

        return businessRank;
    }
}
