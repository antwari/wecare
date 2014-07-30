package com.app.wecare.dao;


import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.wecare.model.Employee;
import com.app.wecare.model.EmployeeRole;
import com.app.wecare.model.Role;

// Role Data access object

public class RoleDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_ROLE_ID, MySQLiteHelper.KEY_ROLE_NAME, MySQLiteHelper.KEY_ROLE_MODIFIED_ON};
    Context context;


    public RoleDAO(Context context) {
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

    public void addRole(String name, String modifiedOn) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_ROLE_NAME, name);
        values.put(MySQLiteHelper.KEY_ROLE_MODIFIED_ON, modifiedOn);
        database.insert(MySQLiteHelper.TABLE_ROLE, null, values);

    }

    // put cursor into Role object
    private Role cursorToRole(Cursor cursor) {
        Role role = new Role();
        role.setId(cursor.getInt(0));
        role.setName(cursor.getString(1));
        role.setModifiedOn(cursor.getString(2));
        return role;
    }

    public int updateRole(int id, String name, String modifiedOn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_ROLE_NAME, name);
        values.put(MySQLiteHelper.KEY_ROLE_MODIFIED_ON, modifiedOn);
        int num = database.update(MySQLiteHelper.TABLE_ROLE, values, MySQLiteHelper.KEY_ROLE_ID + " = " + id, null);
        return num;
    }

    public void deleteRoleByRoleObject(Role role) {
        database.delete(MySQLiteHelper.TABLE_ROLE, MySQLiteHelper.KEY_ROLE_ID + " = " + role.getId(), null);

    }

    public List<Role> getAllRoles() {
        List<Role> roles = new LinkedList<Role>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_ROLE;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build department and add it to list
        if (cursor.moveToFirst()) {
            do {
                Role role = cursorToRole(cursor);
                roles.add(role);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();

        return roles;
    }

    public Role getRoleById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_ROLE, // a. table
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

        Role role = cursorToRole(cursor);

        cursor.close();
        return role;
    }

    public List<EmployeeRole> getAllEmployeesRoles(List<Employee> employees) {
        List<EmployeeRole> employeeRoles = new LinkedList<EmployeeRole>();


        if (employees.size() > 0) {
            for (Employee employee : employees) {
                EmployeeRole employeeRole = new EmployeeRole();
                employeeRole.setEmployeeId(employee.getId());
                employeeRole.setRole(getRoleById(employee.getRoleId()).getName());
                employeeRoles.add(employeeRole);

            }

        }

        return employeeRoles;
    }

}
