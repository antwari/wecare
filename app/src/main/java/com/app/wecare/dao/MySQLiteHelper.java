package com.app.wecare.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // database and database version here
    public static final String DATABASE_NAME = "customer";
    private static final int DATABASE_VERSION = 1;

    //database table names
    public static final String TABLE_EMPLOYEE = "employee";
    public static final String TABLE_EMPLOYEE_RANK = "employee_rank";
    public static final String TABLE_BUSINESS_RANK = "business_rank";
    public static final String TABLE_ROLE = "role";
    public static final String TABLE_DEPARTMENT = "department";
    public static final String TABLE_QUESTION = "question";
    public static final String TABLE_BUSINESS_RANK_COMMENT = "business_rank_comment";
    public static final String TABLE_EMPLOYEE_RANK_COMMENT = "employee_rank_comment";
    public static final String TABLE_QUESTION_BUSINESS_RANK = "question_business_rank";
    public static final String TABLE_QUESTION_EMPLOYEE_RANK = "question_employee_rank";


    // TABLE_EMPLOYEE_RANK Columns names
    public static final String KEY_EMPLOYEE_ID = "id";
    public static final String KEY_EMPLOYEE_DEPARTMENT_ID = "department_id";
    public static final String KEY_EMPLOYEE_NUMBER_ASSIGNED = "number_assigned";
    public static final String KEY_EMPLOYEE_FIRST_NAME = "first_name";
    public static final String KEY_EMPLOYEE_LAST_NAME = "last_name";
    public static final String KEY_EMPLOYEE_EMAIL = "email";
    public static final String KEY_EMPLOYEE_PASSWORD = "password";
    public static final String KEY_EMPLOYEE_PHONE_NUMBER = "phone_number";
    public static final String KEY_EMPLOYEE_ROLE_ID = "role_id";
    public static final String KEY_EMPLOYEE_STATUS = "status"; // O for employee , 1 for administrator
    public static final String KEY_EMPLOYEE_IMAGE_NAME = "image_name";
    public static final String KEY_EMPLOYEE_MODIFIED_ON = "modified_on";

    // TABLE_DEPARTMENT Columns names
    public static final String KEY_DEPARTMENT_ID = "id";
    public static final String KEY_DEPARTMENT_NAME = "name";
    public static final String KEY_DEPARTMENT_MODIFIED_ON = "modified_on";

    // TABLE_ROLE Columns names
    public static final String KEY_ROLE_ID = "id";
    public static final String KEY_ROLE_NAME = "name";
    public static final String KEY_ROLE_MODIFIED_ON = "modified_on";

    // TABLE_EMPLOYEE_RANK Table Columns names
    public static final String KEY_EMPLOYEE_RANK_ID = "id";
    public static final String KEY_EMPLOYEE_RANK_EMPLOYEE_ID = "employee_id";
    public static final String KEY_EMPLOYEE_RANK_RANK = "rank";
    public static final String KEY_EMPLOYEE_RANK_DATE = "date";

    // TABLE_BUSINESS_RANK Columns names
    public static final String KEY_BUSINESS_RANK_ID = "id";
    public static final String KEY_BUSINESS_RANK_RANK = "rank";
    public static final String KEY_BUSINESS_RANK_DATE = "date";

    //  TABLE_QUESTION Columns names
    public static final String KEY_QUESTION_ID = "id";
    public static final String KEY_QUESTION_NAME = "name";
    public static final String KEY_QUESTION_CATEGORY = "category";
    public static final String KEY_QUESTION_MODIFIED_ON = "modified_on";


    // TABLE_BUSINESS_RANK_COMMENT  Columns names
    public static final String KEY_BUSINESS_RANK_COMMENT_ID = "id";
    public static final String KEY_BUSINESS_RANK_COMMENT_NAME = "name";
    public static final String KEY_BUSINESS_RANK_COMMENT_BUSINESS_RANK_Id = "business_rank_id";

    // TABLE_EMPLOYEE_RANK_COMMENT  Columns names
    public static final String KEY_EMPLOYEE_RANK_COMMENT_ID = "id";
    public static final String KEY_EMPLOYEE_RANK_COMMENT_NAME = "name";
    public static final String KEY_EMPLOYEE_RANK_COMMENT_EMPLOYEE_RANK_Id = "employee_rank_id";


    // TABLE_QUESTION_BUSINESS_RANK Columns names
    public static final String KEY_QUESTION_BUSINESS_RANK_ID = "id";
    public static final String KEY_QUESTION_BUSINESS_RANK_QUESTION_ID = "question_id";
    public static final String KEY_QUESTION_BUSINESS_RANK_BUSINESS_RANK_Id = "business_rank_id";

    // TABLE_QUESTION_EMPLOYEE_RANK Columns names
    public static final String KEY_QUESTION_EMPLOYEE_RANK_ID = "id";
    public static final String KEY_QUESTION_EMPLOYEE_RANK_QUESTION_ID = "question_id";
    public static final String KEY_QUESTION_EMPLOYEE_RANK_EMPLOYEE_RANK_Id = "employee_rank_id";


    // query for creating TABLE_EMPLOYEE
    private static final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE "
            + TABLE_EMPLOYEE + " ( " + KEY_EMPLOYEE_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_EMPLOYEE_DEPARTMENT_ID + " INTEGER, "
            + KEY_EMPLOYEE_NUMBER_ASSIGNED + " TEXT, "
            + KEY_EMPLOYEE_FIRST_NAME + " TEXT, " + KEY_EMPLOYEE_LAST_NAME
            + " TEXT, " + KEY_EMPLOYEE_EMAIL + " TEXT, "
            + KEY_EMPLOYEE_PASSWORD + " TEXT, " + KEY_EMPLOYEE_PHONE_NUMBER
            + " TEXT, " + KEY_EMPLOYEE_ROLE_ID + " INTEGER, " + KEY_EMPLOYEE_STATUS + " INTEGER, "
            + KEY_EMPLOYEE_IMAGE_NAME + " TEXT(100), "
            + KEY_EMPLOYEE_MODIFIED_ON + " TEXT);";

    // query for creating TABLE_DEPARTMENT
    private static final String CREATE_TABLE_DEPARTMENT = "CREATE TABLE "
            + TABLE_DEPARTMENT + " ( " + KEY_DEPARTMENT_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DEPARTMENT_NAME
            + " TEXT , " + KEY_DEPARTMENT_MODIFIED_ON + "  TEXT);";

    // query creating TABLE_ROLE
    private static final String CREATE_TABLE_ROLE = "CREATE TABLE "
            + TABLE_ROLE + " ( " + KEY_ROLE_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ROLE_NAME
            + " TEXT, " + KEY_ROLE_MODIFIED_ON + " TEXT);";

    // query creating TABLE_EMPLOYEE_RANK

    private static final String CREATE_TABLE_EMPLOYEE_RANK = "CREATE TABLE "
            + TABLE_EMPLOYEE_RANK + " ( " + KEY_EMPLOYEE_RANK_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_EMPLOYEE_RANK_EMPLOYEE_ID + " INTEGER, "
            + KEY_EMPLOYEE_RANK_RANK + " INTEGER, " + KEY_EMPLOYEE_RANK_DATE
            + " TEXT );";

    // query creating TABLE_BUSINESS_RANK
    private static final String CREATE_TABLE_BUSINESS_RANK = "CREATE TABLE "
            + TABLE_BUSINESS_RANK + " ( " + KEY_BUSINESS_RANK_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_BUSINESS_RANK_RANK
            + " INTEGER, " + KEY_BUSINESS_RANK_DATE + " TEXT );";

    // query creating TABLE_QUESTION
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE "
            + TABLE_QUESTION + " ( " + KEY_QUESTION_ID
            + " INTEGER PRIMARY KEY , " + KEY_QUESTION_NAME
            + " TEXT, " + KEY_QUESTION_CATEGORY + " INTEGER , " + KEY_QUESTION_MODIFIED_ON + " TEXT);";

    // query creating TABLE_BUSINESS_RANK_COMMENT
    private static final String CREATE_TABLE_BUSINESS_RANK_COMMENT = "CREATE TABLE "
            + TABLE_BUSINESS_RANK_COMMENT + " ( " + KEY_BUSINESS_RANK_COMMENT_ID
            + " INTEGER PRIMARY KEY , " + KEY_BUSINESS_RANK_COMMENT_NAME
            + " TEXT, " + KEY_BUSINESS_RANK_COMMENT_BUSINESS_RANK_Id + " INTEGER );";


    // query creating TABLE_QUESTION_BUSINESS_RANK
    private static final String CREATE_TABLE_QUESTION_BUSINESS_RANK = "CREATE TABLE "
            + TABLE_QUESTION_BUSINESS_RANK + " ( " + KEY_QUESTION_BUSINESS_RANK_ID
            + " INTEGER PRIMARY KEY , " + KEY_QUESTION_BUSINESS_RANK_QUESTION_ID
            + " INTEGER, " + KEY_QUESTION_BUSINESS_RANK_BUSINESS_RANK_Id + " INTEGER );";


    // query creating TABLE_QUESTION_BUSINESS_RANK tables
    private static final String CREATE_TABLE_EMPLOYEE_RANK_COMMENT = "CREATE TABLE "
            + TABLE_EMPLOYEE_RANK_COMMENT + " ( " + KEY_EMPLOYEE_RANK_COMMENT_ID
            + " INTEGER PRIMARY KEY , " + KEY_EMPLOYEE_RANK_COMMENT_NAME
            + " TEXT, " + KEY_EMPLOYEE_RANK_COMMENT_EMPLOYEE_RANK_Id + " INTEGER );";

    // query creating TABLE_QUESTION_EMPLOYEE_RANK tables
    private static final String CREATE_TABLE_QUESTION_EMPLOYEE_RANK = "CREATE TABLE "
            + TABLE_QUESTION_EMPLOYEE_RANK + " ( " + KEY_QUESTION_EMPLOYEE_RANK_ID
            + " INTEGER PRIMARY KEY , " + KEY_QUESTION_EMPLOYEE_RANK_QUESTION_ID
            + " INTEGER, " + KEY_QUESTION_EMPLOYEE_RANK_EMPLOYEE_RANK_Id + " INTEGER );";

    private final Context context;

    // constructor of this class
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onOpen(SQLiteDatabase database) {

        Log.v("DO", "Database opened");
    }

    // called for creating the database
    @Override
    public void onCreate(SQLiteDatabase database) {

        // creating tables in the database
        database.execSQL(CREATE_TABLE_EMPLOYEE);
        database.execSQL(CREATE_TABLE_DEPARTMENT);
        database.execSQL(CREATE_TABLE_ROLE);
        database.execSQL(CREATE_TABLE_EMPLOYEE_RANK);
        database.execSQL(CREATE_TABLE_BUSINESS_RANK);
        database.execSQL(CREATE_TABLE_QUESTION);
        database.execSQL(CREATE_TABLE_BUSINESS_RANK_COMMENT);
        database.execSQL(CREATE_TABLE_EMPLOYEE_RANK_COMMENT);
        database.execSQL(CREATE_TABLE_QUESTION_BUSINESS_RANK);
        database.execSQL(CREATE_TABLE_QUESTION_EMPLOYEE_RANK);

        // adding values in the tables
        SampleDatabaseData sampleObject = new SampleDatabaseData();
        sampleObject.insertSampleDataInDatabase(database);

        Log.v("DC", "Database created");
    }

    // called when you want to re install the application
    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE_RANK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUSINESS_RANK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUSINESS_RANK_COMMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE_RANK_COMMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_BUSINESS_RANK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_EMPLOYEE_RANK);

        // create new tables
        onCreate(db);

        Log.v("DU", "Database Upgrade");
    }

    /*
     * check if a given table is not empty
     */
    public boolean checkIfTAbleHasData(String tableName) {
        boolean hasData = false;
        SQLiteDatabase database = this.getWritableDatabase();
        String columns[] = new String[]{"id"};
        try {
            Cursor cursor = database.query(tableName, columns, null, null,
                    null, null, null);
            if (cursor.getCount() > 0)
                hasData = true;
        } catch (Exception e) {
            Log.w("HD", "Problem deleting tables" + e);

        } finally {
            database.close();
        }

        return hasData;
    }

    // creating sample data in the database
    public void sampleData(SQLiteDatabase db) {

    }

}
