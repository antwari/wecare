package com.app.wecare.dao;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.Department;

// Department Data access object

public class DepartmentDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_DEPARTMENT_ID, MySQLiteHelper.KEY_DEPARTMENT_NAME, MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON};
    Context context;


    public DepartmentDAO(Context context) {
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

    public void addDepartment(String name, String modifiedOn) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, name);
        values.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, modifiedOn);
        database.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, values);

    }

    // put cursor into Department object
    private Department cursorToDepartment(Cursor cursor) {
        Department department = new Department();
        department.setId(cursor.getInt(0));
        department.setName(cursor.getString(1));
        department.setModifiedOn(cursor.getString(2));
        return department;
    }


    public int updateDepartment(int id, String name, String modifiedOn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, name);
        values.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, modifiedOn);
        int num = database.update(MySQLiteHelper.TABLE_DEPARTMENT, values, MySQLiteHelper.KEY_DEPARTMENT_ID + " = " + id, null);
        return num;
    }

    public void deleteDepartmentByDepartmentObject(Department department) {
        database.delete(MySQLiteHelper.TABLE_DEPARTMENT, MySQLiteHelper.KEY_DEPARTMENT_ID + " = " + department.getId(), null);

    }


    public List<Department> getAllDepartments() {
        List<Department> departments = new LinkedList<Department>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_DEPARTMENT;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build department and add it to list
        Department department = null;


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            department = cursorToDepartment(cursor);
            departments.add(department);
            cursor.moveToNext();
        }


        cursor.close();

        Log.d("getAllDepartments()", departments.toString());

        return departments;
    }

    public Department getDepartmentById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_DEPARTMENT, // a. table
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
        Department department = cursorToDepartment(cursor);
        cursor.close();

        return department;
    }


}
