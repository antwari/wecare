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

import com.app.wecare.model.EmployeeRank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// EmployeeRank Data access object

public class EmployeeRankDAO {


    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_EMPLOYEE_RANK_ID, MySQLiteHelper.KEY_EMPLOYEE_RANK_EMPLOYEE_ID, MySQLiteHelper.KEY_EMPLOYEE_RANK_RANK, MySQLiteHelper.KEY_EMPLOYEE_RANK_DATE};
    Context context;


    public EmployeeRankDAO(Context context) {
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

    public void addBusinessRank(int employeeId, int rank) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_EMPLOYEE_ID, employeeId);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_RANK, rank);

        // getting the current time and date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

        Date date = new Date();
        String currentDateTime = dateFormat.format(date);

        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_DATE, currentDateTime);
        database.insert(MySQLiteHelper.TABLE_EMPLOYEE_RANK, null, values);

    }

    // put cursor into EmployeeRank object
    private EmployeeRank cursorToEmployeeRank(Cursor cursor) {

        EmployeeRank item = new EmployeeRank();
        item.setId(cursor.getInt(0));
        item.setEmployeeId(cursor.getInt(1));
        item.setRank(cursor.getInt(2));
        item.setDate(cursor.getString(3));
        return item;

    }

    public int updateEmployeeRank(int id, int employeeId, int rank, String date) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_EMPLOYEE_ID, employeeId);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_RANK, rank);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_RANK_DATE, date);
        int num = database.update(MySQLiteHelper.TABLE_EMPLOYEE_RANK, values, MySQLiteHelper.KEY_EMPLOYEE_RANK_ID + " = " + id, null);
        return num;

    }

    public void deleteEmployeeRankByEmployeeRankObject(EmployeeRank employeeRank) {
        database.delete(MySQLiteHelper.TABLE_EMPLOYEE_RANK, MySQLiteHelper.KEY_EMPLOYEE_RANK_ID + " = " + employeeRank.getId(), null);

    }

    public List<EmployeeRank> getAllEmployeeRank() {
        List<EmployeeRank> employeeRanks = new LinkedList<EmployeeRank>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_EMPLOYEE_RANK;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build EmployeeRank and add it to list
        if (cursor.moveToFirst()) {
            do {
                EmployeeRank employeeRank = cursorToEmployeeRank(cursor);
                employeeRanks.add(employeeRank);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return employeeRanks;
    }

    public EmployeeRank getEmployeeRankById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE_RANK, // a. table
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
        EmployeeRank employeeRank = cursorToEmployeeRank(cursor);
        cursor.close();

        return employeeRank;
    }
}
