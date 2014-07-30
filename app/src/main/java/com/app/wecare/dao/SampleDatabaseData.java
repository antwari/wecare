package com.app.wecare.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SampleDatabaseData {


    public void insertSampleDataInDatabase(SQLiteDatabase db) {

        // inserting employee slang
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "NTWARI SHYAKA");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "AIME");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "a");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "a");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 1);
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "shyaka.png");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 1);
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0783301560");
        cv.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 001");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, cv);

        // inserting employee Mahirwe
        ContentValues img1 = new ContentValues();
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mahirwe");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Yvonne");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "m");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "m");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 2);
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "cherie.png");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 1);
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788580091");
        img1.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 002");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img1);

        // inserting employee Eben
        ContentValues img2 = new ContentValues();
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Eben");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "eben");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mubiligi");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 1);
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "eben.png");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788567890");
        img2.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 003");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img2);

        // inserting employee Ezer
        ContentValues img4 = new ContentValues();
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Ezer");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "ezer");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mubiligi");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 3);
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 2);
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "ezer.png");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788908796");
        img4.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 004");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img4);

        // inserting employee Lily
        ContentValues img5 = new ContentValues();
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Lili");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "NyinawaYezu");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "lili");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "lili");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 2);
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 3);
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "lily.png");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788990088");
        img5.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 005");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img5);

        // inserting employee Mugenzi
        ContentValues img6 = new ContentValues();
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mugenzi");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Aime");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mugenzi");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mugenzi");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 1);
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 2);
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mugenzi.png");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788009911");
        img6.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 006");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img6);

        // inserting employee Mugisha
        ContentValues img7 = new ContentValues();
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mugisha");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Esther");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mugisha");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mugisha");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 2);
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 3);
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mugisha.png");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788871234");
        img7.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 007");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img7);

        // inserting employee Mulisa
        ContentValues img8 = new ContentValues();
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img8.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 008");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img8);

        // inserting employee Mulisa
        ContentValues img9 = new ContentValues();
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img9.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 009");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img9);

        // inserting employee Mulisa
        ContentValues img10 = new ContentValues();
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img10.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0010");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img10);

        // inserting employee Mulisa
        ContentValues img11 = new ContentValues();
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img11.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0011");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img11);

        // inserting employee Mulisa
        ContentValues img12 = new ContentValues();
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img12.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0012");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img12);

        // inserting employee Mulisa
        ContentValues img13 = new ContentValues();
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img13.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0013");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img13);

        // inserting employee Mulisa
        ContentValues img14 = new ContentValues();
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img14.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0014");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img14);

        // inserting employee Mulisa
        ContentValues img15 = new ContentValues();
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img15.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0015");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img15);

        // inserting employee Mulisa
        ContentValues img16 = new ContentValues();
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img16.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0016");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img16);

        // inserting employee Mulisa
        ContentValues img17 = new ContentValues();
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img17.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0017");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img17);

        // inserting employee Mulisa
        ContentValues img18 = new ContentValues();
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img18.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0018");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img18);

        // inserting employee Mulisa
        ContentValues img19 = new ContentValues();
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mulisa");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mulisa");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 5);
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 0);
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img19.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0019");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img19);

        // inserting employee Mulisa
        ContentValues img20 = new ContentValues();
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "Mulisa");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "Mubiligi");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "mu");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "mu");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 4);
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 1);
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "mulisa.png");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 1);
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "12:30PM");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0788881209");
        img20.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0020");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img20);

        // inserting employee Slang
        ContentValues img21 = new ContentValues();
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_FIRST_NAME, "NTWARI SHYAKA");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_LAST_NAME, "AIME");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_EMAIL, "a");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_PASSWORD, "a");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_ROLE_ID, 1);
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_DEPARTMENT_ID, 2);
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_IMAGE_NAME, "shyaka.png");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_STATUS, 1);
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_MODIFIED_ON, "5:56 AM");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_PHONE_NUMBER, "0783301560");
        img21.put(MySQLiteHelper.KEY_EMPLOYEE_NUMBER_ASSIGNED, "TELLER 0021");
        db.insert(MySQLiteHelper.TABLE_EMPLOYEE, null, img21);

        // <inserting into department table>
        ContentValues dp1 = new ContentValues();
        dp1.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "MARKETING");
        dp1.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:30PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp1);

        ContentValues dp2 = new ContentValues();
        dp2.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "CASHIER");
        dp2.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:30PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp2);

        ContentValues dp3 = new ContentValues();
        dp3.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "SELLS");
        dp3.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:08PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp3);

        ContentValues dp4 = new ContentValues();
        dp4.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "FINANCE");
        dp4.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:06PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp4);

        ContentValues dp5 = new ContentValues();
        dp5.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "SECURITY");
        dp5.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:05PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp5);

        ContentValues dp6 = new ContentValues();
        dp6.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "CREDIT");
        dp6.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:04PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp6);

        ContentValues dp7 = new ContentValues();
        dp7.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "ACCOUNTING");
        dp7.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:04PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp7);

        ContentValues dp8 = new ContentValues();
        dp8.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "LOAN");
        dp8.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:04PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp8);

        ContentValues dp9 = new ContentValues();
        dp9.put(MySQLiteHelper.KEY_DEPARTMENT_NAME, "CASH");
        dp9.put(MySQLiteHelper.KEY_DEPARTMENT_MODIFIED_ON, "12:04PM");
        db.insert(MySQLiteHelper.TABLE_DEPARTMENT, null, dp9);

        // </inserting into department table>

        // <inserting into role table>
        ContentValues role1 = new ContentValues();
        role1.put(MySQLiteHelper.KEY_ROLE_NAME, "CUSTOMER CARE");
        role1.put(MySQLiteHelper.KEY_ROLE_MODIFIED_ON, "12:04PM");
        db.insert(MySQLiteHelper.TABLE_ROLE, null, role1);

        ContentValues role2 = new ContentValues();
        role2.put(MySQLiteHelper.KEY_ROLE_NAME, "TELLER");
        role2.put(MySQLiteHelper.KEY_ROLE_MODIFIED_ON, "11:09PM");
        db.insert(MySQLiteHelper.TABLE_ROLE, null, role2);

        ContentValues role3 = new ContentValues();
        role3.put(MySQLiteHelper.KEY_ROLE_NAME, "BRANCH MANAGER");
        role3.put(MySQLiteHelper.KEY_ROLE_MODIFIED_ON, "10:09AM");
        db.insert(MySQLiteHelper.TABLE_ROLE, null, role3);

        ContentValues role4 = new ContentValues();
        role4.put(MySQLiteHelper.KEY_ROLE_NAME, "MANAGER");
        role4.put(MySQLiteHelper.KEY_ROLE_MODIFIED_ON, "01:09AM");
        db.insert(MySQLiteHelper.TABLE_ROLE, null, role4);

        // </inserting into role table>


        // <inserting into question table>
        // poor
        ContentValues quest1 = new ContentValues();
        quest1.put(MySQLiteHelper.KEY_QUESTION_ID, 1);
        quest1.put(MySQLiteHelper.KEY_QUESTION_NAME, "Poor Service  (service mbi)");
        quest1.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 0);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest1);

        ContentValues quest2 = new ContentValues();
        quest2.put(MySQLiteHelper.KEY_QUESTION_ID, 2);
        quest2.put(MySQLiteHelper.KEY_QUESTION_NAME, "Poor communication (avuga nabi)");
        quest2.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 0);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest2);


        ContentValues quest3 = new ContentValues();
        quest3.put(MySQLiteHelper.KEY_QUESTION_ID, 3);
        quest3.put(MySQLiteHelper.KEY_QUESTION_NAME, "Poor Timing (yatinze)");
        quest3.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 0);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest3);

        ContentValues quest4 = new ContentValues();
        quest4.put(MySQLiteHelper.KEY_QUESTION_ID, 4);
        quest4.put(MySQLiteHelper.KEY_QUESTION_NAME, "Poor Explanation (asobanura nabi)");
        quest4.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 0);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest4);


        ContentValues quest5 = new ContentValues();
        quest5.put(MySQLiteHelper.KEY_QUESTION_ID, 5);
        quest5.put(MySQLiteHelper.KEY_QUESTION_NAME, "Poor Customer care (yakirana nabi)");
        quest5.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 0);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest5);


        // average
        ContentValues quest6 = new ContentValues();
        quest6.put(MySQLiteHelper.KEY_QUESTION_ID, 6);
        quest6.put(MySQLiteHelper.KEY_QUESTION_NAME, "Average Service  (service iragerageza)");
        quest6.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 1);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest6);

        ContentValues quest7 = new ContentValues();
        quest7.put(MySQLiteHelper.KEY_QUESTION_ID, 7);
        quest7.put(MySQLiteHelper.KEY_QUESTION_NAME, "Average communication (agerageza kuvuga neza)");
        quest7.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 1);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest7);


        ContentValues quest8 = new ContentValues();
        quest8.put(MySQLiteHelper.KEY_QUESTION_ID, 8);
        quest8.put(MySQLiteHelper.KEY_QUESTION_NAME, "Average Timing (ntatinda cyane)");
        quest8.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 1);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest8);

        ContentValues quest9 = new ContentValues();
        quest9.put(MySQLiteHelper.KEY_QUESTION_ID, 9);
        quest9.put(MySQLiteHelper.KEY_QUESTION_NAME, "Average Explanation (ntasobanura neza cyane)");
        quest9.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 1);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest9);


        ContentValues quest10 = new ContentValues();
        quest10.put(MySQLiteHelper.KEY_QUESTION_ID, 10);
        quest10.put(MySQLiteHelper.KEY_QUESTION_NAME, "Average Customer care (ntiyakirana nabi cyane)");
        quest10.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 1);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest10);


        // average
        ContentValues quest11 = new ContentValues();
        quest11.put(MySQLiteHelper.KEY_QUESTION_ID, 11);
        quest11.put(MySQLiteHelper.KEY_QUESTION_NAME, "Good Service  (service ni nziza)");
        quest11.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 2);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest11);

        ContentValues quest12 = new ContentValues();
        quest12.put(MySQLiteHelper.KEY_QUESTION_ID, 12);
        quest12.put(MySQLiteHelper.KEY_QUESTION_NAME, "Good communication (avuga neza)");
        quest12.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 2);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest12);


        ContentValues quest13 = new ContentValues();
        quest13.put(MySQLiteHelper.KEY_QUESTION_ID, 13);
        quest13.put(MySQLiteHelper.KEY_QUESTION_NAME, "Good Timing (arihuta cyane)");
        quest13.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 2);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest13);

        ContentValues quest14 = new ContentValues();
        quest14.put(MySQLiteHelper.KEY_QUESTION_ID, 14);
        quest14.put(MySQLiteHelper.KEY_QUESTION_NAME, "Good Explanation (asobanura neza cyane)");
        quest14.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 2);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest14);


        ContentValues quest15 = new ContentValues();
        quest15.put(MySQLiteHelper.KEY_QUESTION_ID, 15);
        quest15.put(MySQLiteHelper.KEY_QUESTION_NAME, "Good Customer care (yakira neza cyane)");
        quest15.put(MySQLiteHelper.KEY_QUESTION_CATEGORY, 2);
        db.insert(MySQLiteHelper.TABLE_QUESTION, null, quest15);

        // </inserting into question table>
        Log.v("DI", "Data inserted  Successfully !!!!!!!");
    }

}
