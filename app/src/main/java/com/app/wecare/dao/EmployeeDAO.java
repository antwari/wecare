package com.app.wecare.dao;

/*
* Employee Data access object
 */

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.app.wecare.model.Employee;
import com.app.wecare.model.EmployeeDepartment;
import com.app.wecare.model.EmployeeImage;
import com.app.wecare.model.EmployeeRole;
import com.app.wecare.util.ImageChanger;

public class EmployeeDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.KEY_EMPLOYEE_ID, MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, MySQLiteHelper.KEY_EMPLOYEE_EMAIL, MySQLiteHelper.KEY_EMPLOYEE_PASSWORD,
            MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, MySQLiteHelper.KEY_EMPLOYEE_STATUS, MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON};
    Context context;


    public EmployeeDAO(Context context) {
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

    public void addEmployee(int departmentId, String numberAssigned,
                            String firstName, String lastName, String email, String password,
                            String phoneNumber, int roleId, int status, String imgName,
                            String modifiedOn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, departmentId);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, numberAssigned);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, firstName);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, lastName);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, email);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, password);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, phoneNumber);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, roleId);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, status);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, imgName);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, modifiedOn);

        database.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, values);

    }

    // put cursor into Employee object
    private Employee cursorToEmployee(Cursor cursor) {
        Employee item = new Employee();
        item.setId(cursor.getInt(0));
        item.setDepartmentId(cursor.getInt(1));
        item.setNumberAssigned(cursor.getString(2));
        item.setFirstName(cursor.getString(3));
        item.setLastName(cursor.getString(4));
        item.setEmail(cursor.getString(5));
        item.setPassword(cursor.getString(6));
        item.setPhoneNumber(cursor.getString(7));
        item.setRoleId(cursor.getInt(8));
        item.setStatus(cursor.getInt(9));
        item.setImageName(cursor.getString(10));
        item.setModifiedOn(cursor.getString(11));
        return item;
    }

    public int updateEmployee(int id, int departmentId, String numberAssigned,
                              String firstName, String lastName, String email, String password,
                              String phoneNumber, int roleId, int status, String imgName,
                              String modifiedOn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, departmentId);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, numberAssigned);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, firstName);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, lastName);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, email);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, password);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, phoneNumber);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, roleId);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, status);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, imgName);
        values.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, modifiedOn);
        int num = database.update(MySQLiteHelper.TABLE_EMPLOYEE, values, MySQLiteHelper.KEY_EMPLOYEE_ID + " = " + id, null);
        return num;
    }

    public int updateEmployeeAssignedNumberByEmployeeId(int id, String numberAssigned) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, numberAssigned);
        int num = database.update(MySQLiteHelper.TABLE_EMPLOYEE, values, MySQLiteHelper.KEY_EMPLOYEE_ID + " = " + id, null);
        return num;
    }

    // this method is used in order to avoid the repetition of the same numberAssigned
    public int setAllEmployeeAssignedNumberToEmpty(String numberAssigned) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "");
        int num = database.update(MySQLiteHelper.TABLE_EMPLOYEE, values, MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED + " = " + numberAssigned, null);
        return num;
    }

    public void deleteEmployeeByEmployeeObject(Employee employee) {
        database.delete(MySQLiteHelper.TABLE_EMPLOYEE, MySQLiteHelper.KEY_EMPLOYEE_ID + " = " + employee.getId(), null);

    }

    // get All employees into a list of Employee
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new LinkedList<Employee>();

        //  build the query
        String query = " SELECT  * FROM " + MySQLiteHelper.TABLE_EMPLOYEE;

        Cursor cursor = database.rawQuery(query, null);

        //  go over each row, build employe and add it to list
        if (cursor.moveToFirst()) {
            do {
                Employee employee = cursorToEmployee(cursor);
                employees.add(employee);
                cursor.moveToNext();

            } while (cursor.moveToNext());
        }

        cursor.close();
        return employees;
    }

    public Employee getEmployeeById(int id) {

        //  build query
        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE, // a. table
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
        Employee employee = cursorToEmployee(cursor); //  build Employee object
        cursor.close();


        return employee;
    }

    // method for checking if the user login successfully
    public boolean checkLogin(String email, String password) {

        // TODO Auto-generated method stub
        String status = "1"; // 0 for employee , 1 for administrator
        String selection = MySQLiteHelper.KEY_EMPLOYEE_EMAIL + " = ? AND " + MySQLiteHelper.KEY_EMPLOYEE_PASSWORD
                + " = ? AND " + MySQLiteHelper.KEY_EMPLOYEE_STATUS + " = ? ";
        String[] selectionArgs = {email, password, status};
        Cursor c = database.query(MySQLiteHelper.TABLE_EMPLOYEE, null, selection,
                selectionArgs, null, null, null);
        int count = c.getCount();
        c.close();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }


    public List<Employee> getEmployeesByDepartmentIdAndSearchKeyword(int id, String query) {
        List<Employee> employees = new LinkedList<Employee>();

        query = "%" + query + "%";
        String selectQuery = " select * from " + MySQLiteHelper.TABLE_EMPLOYEE + " where " + MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME + " like  '"
                + query
                + "' OR  " + MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME + " LIKE '" + query + "' AND " + MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID + " = " + String.valueOf(id);

        Cursor cursor = database.rawQuery(selectQuery, null);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            Employee employee = cursorToEmployee(cursor);
            employees.add(employee);
        }


        cursor.close();
        System.out.println(employees.size());

        Log.d("getEmployeesByDepartmentIdAndSearchKeyword()", employees.toString());

        return employees;
    }


    public List<Employee> getEmployeesByDepartmentId(int id) {
        List<Employee> employees = new LinkedList<Employee>();

        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        //  go over each row, build employee and add it to employee list of employees
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Employee employee = cursorToEmployee(cursor);
            employees.add(employee);
        }


        cursor.close();
        System.out.println(employees.size());

        Log.d("getEmployeesByDepartmentId()", employees.toString());

        return employees;
    }


    /*
    *check if department has employee
    *return true if department has at least one employee or more and false if it has no employee
    */
    public boolean CheckIfDepartmentHasEmployee(int id) {


        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID + " = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        int numberOfEmployees = cursor.getCount();
        cursor.close();
        if (numberOfEmployees > 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkIfAssignedNumberExist(String assignedNumber) {


        Cursor cursor =
                database.query(MySQLiteHelper.TABLE_EMPLOYEE, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED + " = ?", // c. selections
                        new String[]{assignedNumber}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        int count = cursor.getCount();
        cursor.close();
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }


    /*
    *path of images on nexus : /storage/emulated/0/institution/
    * path of images on samsung : /storage/sdcard0/institution/
     */

    public EmployeeImage getEmployeeImage(Employee employee) {

        ImageChanger imageChanger = new ImageChanger();


        String strPath = "/storage/emulated/0/institution/"
                + employee.getImageName();

        Bitmap bm = imageChanger.getCircledBitmap(
                BitmapFactory.decodeFile(strPath), 1000);

        EmployeeImage employeeImage = new EmployeeImage();
        employeeImage.setId(employee.getId());
        employeeImage.setImage(bm);

        Log.d("getEmployeeImage()", employeeImage.toString());
        return employeeImage;
    }


    public EmployeeImage getEmployeeImageInNormalShape(Employee employee) {


        String strPath = "/storage/emulated/0/institution/"
                + employee.getImageName();

        Bitmap bm = BitmapFactory.decodeFile(strPath);

        EmployeeImage employeeImage = new EmployeeImage();
        employeeImage.setId(employee.getId());
        employeeImage.setImage(bm);

        Log.d("getEmployeeImageInNormalShape()", employeeImage.toString());
        return employeeImage;
    }

    public List<EmployeeImage> getAllEmployeesImages(List<Employee> employees) {
        List<EmployeeImage> images = new LinkedList<EmployeeImage>();
        ImageChanger imageChanger = new ImageChanger();


        if (employees.size() > 0) {
            for (Employee employee : employees) {

                String strPath = "/storage/emulated/0/institution/"
                        + employee.getImageName();

                Bitmap bm = imageChanger.getCircledBitmap(
                        BitmapFactory.decodeFile(strPath), 1000);

                EmployeeImage image = new EmployeeImage();
                image.setId(employee.getId());
                image.setImage(bm);
                images.add(image);

            }

        }

        Log.d("getAllEmployeesImages()", images.toString());

        return images;
    }

    public EmployeeDepartment getEmployeeDepartment(Employee employee) {
        String[] allColumns = {MySQLiteHelper.KEY_DEPARTMENT_ID, MySQLiteHelper.KEY_DEPARTMENT_NAME, MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON};


        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setEmployeeId(employee.getId());

        Cursor cursor = database.query(MySQLiteHelper.TABLE_DEPARTMENT, // a. table
                allColumns, // b. column names
                MySQLiteHelper.KEY_DEPARTMENT_ID + " = ?", // c. selections
                new String[]{String.valueOf(employee.getDepartmentId())}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        int iDepartment = cursor.getColumnIndex(MySQLiteHelper.KEY_DEPARTMENT_NAME);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            employeeDepartment.setDepartment(cursor.getString(iDepartment));
        }


        cursor.close();


        Log.d("getEmployeeDepartment()", employeeDepartment.toString());

        return employeeDepartment;
    }


    public EmployeeRole getEmployeeRole(Employee employee) {
        String[] allColumns = {MySQLiteHelper.KEY_ROLE_ID, MySQLiteHelper.KEY_ROLE_NAME, MySQLiteHelper.KEY_ROLE_MODIFIED_ON};


        EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setEmployeeId(employee.getId());
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ROLE, // a. table
                allColumns, // b. column names
                MySQLiteHelper.KEY_ROLE_ID + " = ?", // c. selections
                new String[]{String.valueOf(employee.getRoleId())}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        int iRole = cursor.getColumnIndex(MySQLiteHelper.KEY_ROLE_NAME);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            employeeRole.setRole(cursor.getString(iRole));
        }


        cursor.close();


        Log.d("getEmployeeRole()", employeeRole.toString());

        return employeeRole;
    }

    public List<EmployeeRole> getEmployeesRoles(List<Employee> employees) {
        List<EmployeeRole> employeeRoles = new LinkedList<EmployeeRole>();
        String[] allColumns = {MySQLiteHelper.KEY_ROLE_ID, MySQLiteHelper.KEY_ROLE_NAME, MySQLiteHelper.KEY_ROLE_MODIFIED_ON};


        if (employees.size() > 0) {
            for (Employee employee : employees) {


                EmployeeRole employeeRole = new EmployeeRole();
                employeeRole.setEmployeeId(employee.getId());
                Cursor cursor = database.query(MySQLiteHelper.TABLE_ROLE, // a. table
                        allColumns, // b. column names
                        MySQLiteHelper.KEY_ROLE_ID + " = ?", // c. selections
                        new String[]{String.valueOf(employee.getRoleId())}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

                int iRole = cursor.getColumnIndex(MySQLiteHelper.KEY_ROLE_NAME);

                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    employeeRole.setRole(cursor.getString(iRole));
                }
                cursor.close();
                employeeRoles.add(employeeRole);
            }

        }

        Log.d("getEmployeesRoles()", employeeRoles.toString());

        return employeeRoles;
    }


}
