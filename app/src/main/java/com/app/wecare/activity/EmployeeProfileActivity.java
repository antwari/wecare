package com.app.wecare.activity;


import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.wecare.R;
import com.app.wecare.dao.EmployeeDAO;
import com.app.wecare.model.Employee;
import com.app.wecare.model.EmployeeDepartment;
import com.app.wecare.model.EmployeeImage;
import com.app.wecare.model.EmployeeRole;
import com.app.wecare.util.MyApplication;

/*
* EmployeeProfileActivity
* display a single employee and edit the Assigned Number to the employee (This number can replace employee image based on the preferences)
 */

public class EmployeeProfileActivity extends Activity implements View.OnClickListener {

    private TextView name, department, role, email, phone, numberAssigned;
    private ProgressBar spinner;
    private Button editAssignedNumber;
    private ImageView image;
    private EditText assignedNumber;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_profile_activity);

        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        initializer();

        Intent intent = getIntent();
        String employeeId = intent.getExtras().getString("employeeId");

        new ProfileLoader().execute(employeeId); //


    }

    private void initializer() {

        name = (TextView) findViewById(R.id.tvEmployeeName);
        department = (TextView) findViewById(R.id.tvEmployeeDepartment);
        role = (TextView) findViewById(R.id.tvEmployeeRole);
        email = (TextView) findViewById(R.id.tvEmployeeEmail);
        phone = (TextView) findViewById(R.id.tvEmployeePhone);
        numberAssigned = (TextView) findViewById(R.id.tvEmployeeNumberAssigned);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        editAssignedNumber = (Button) findViewById(R.id.bEditAssignedNumber);
        image = (ImageView) findViewById(R.id.ivEmployeeImage);
        editAssignedNumber.setOnClickListener(this);

    }

    // setting the layout
    public void setGUI(String name, String department, String role, String email, String phone, String numberAssigned, Bitmap image) {

        this.name.setText(name);
        this.department.setText(department);
        this.role.setText(role);
        this.email.setText(email);
        this.phone.setText(phone);
        this.numberAssigned.setText(numberAssigned);
        this.image.setImageBitmap(image); // image

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bEditAssignedNumber:
//                Toast.makeText(getApplicationContext(), "Edit Assigned Number ",
//                        Toast.LENGTH_SHORT).show();

                MyApplication myApp = (MyApplication) getApplication();

                dialog = new Dialog(this);

                dialog.setContentView(R.layout.dialog_assigned_number);
                dialog.setTitle(" Assigned Identification ");
//                dialog.

                assignedNumber = (EditText) dialog.findViewById(R.id.etAssignedNumber);

                assignedNumber.setText(myApp.getEmployeeAssignedNumber());
                Button save = (Button) dialog.findViewById(R.id.btSave);
                Button cancel = (Button) dialog.findViewById(R.id.btCancel);
                save.setOnClickListener(this);
                cancel.setOnClickListener(this);
                dialog.show();
                break;

            case R.id.btSave:

                MyApplication myApplication = (MyApplication) getApplication();
                int employeeId = myApplication.getEmployeeId();
                String employId = employeeId + "";
                employId = employId.trim();

                String assignedNumber = this.assignedNumber.getText().toString();
                dialog.hide();
                new UpdateAssignedNumber().execute(employId, assignedNumber);


                break;
            case R.id.btCancel:
                dialog.hide();
                break;

            case R.id.btYes:
                Toast.makeText(getApplicationContext(), " Yes ",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btNo:
                MyApplication myAp = (MyApplication) getApplication();
                dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialog_assigned_number);
                dialog.setTitle(" Assigned Identification ");
                this.assignedNumber = (EditText) dialog.findViewById(R.id.etAssignedNumber);

                this.assignedNumber.setText(myAp.getEmployeeAssignedNumber());

                save = (Button) dialog.findViewById(R.id.btSave);
                cancel = (Button) dialog.findViewById(R.id.btCancel);
                save.setOnClickListener(this);
                cancel.setOnClickListener(this);
                dialog.show();
                break;
        }
    }

    /**
     * AsyncTask to download and load an image in ListView
     */
    private class UpdateAssignedNumber extends
            AsyncTask<String, Void, Boolean> {


        int employeeId;
        String assignedText;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(String... hm) {
            EmployeeDAO employeeDAO = new EmployeeDAO(EmployeeProfileActivity.this);

            employeeDAO.open();
            employeeId = Integer.parseInt(hm[0]);
            assignedText = hm[1];
            try {
                if (employeeDAO.checkIfAssignedNumberExist(assignedText)) {
                    // set all equal assigned Number field to empty
//                    employeeDAO.setAllEmployeeAssignedNumberToEmpty(assignedText);
                    // update the employee assigned number
                    employeeDAO.updateEmployeeAssignedNumberByEmployeeId(employeeId, assignedText);
                    return true;
                } else {
                    return false;
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employeeDAO.close();
            }


            return null;

        }

        @Override
        protected void onPostExecute(Boolean check) {
            if (check) {
                Toast toast = Toast.makeText(getApplicationContext(), " Edited successfully ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                // go to the current activity in order to update the view

                String employId = employeeId + "";
                employId = employId.trim();


                new ProfileLoader().execute(employId);
            } else {
                dialog = new Dialog(EmployeeProfileActivity.this);
                dialog.setContentView(R.layout.dialog_assigned_number_verification);
                dialog.setTitle(" Do you want to overwrite the existing one ?");
                Button yes = (Button) dialog.findViewById(R.id.btYes);
                Button no = (Button) dialog.findViewById(R.id.btNo);
                yes.setOnClickListener(EmployeeProfileActivity.this);
                no.setOnClickListener(EmployeeProfileActivity.this);
                dialog.show();
            }
        }
    }


    /**
     * AsyncTask to load employee profile
     */
    private class ProfileLoader extends
            AsyncTask<String, Void, Employee> {

        EmployeeImage employeeImages;
        EmployeeRole employeeRole;
        EmployeeDepartment employeeDepartment;
        String employeeAssignedNumber;

        int employeeId;

        // on UI Thread
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            super.onPreExecute();

            spinner.setVisibility(View.VISIBLE); // show ProgressBar

        }

        // on background Thread
        @Override
        protected Employee doInBackground(String... hm) {
            EmployeeDAO employeeDAO = new EmployeeDAO(EmployeeProfileActivity.this);

            employeeDAO.open();
            employeeId = Integer.parseInt(hm[0]);
            try {

                Employee employee = employeeDAO.getEmployeeById(employeeId);
                employeeImages = employeeDAO.getEmployeeImageInNormalShape(employee);
                employeeRole = employeeDAO.getEmployeeRole(employee);
                employeeDepartment = employeeDAO.getEmployeeDepartment(employee);
                employeeAssignedNumber = employee.getNumberAssigned();

                return employee;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employeeDAO.close();
            }


            return null;

        }

        // on UI Thread
        @Override
        protected void onPostExecute(Employee employee) {

            // setting the UI
            setGUI(employee.getFirstName() + " " + employee.getLastName(), employeeDepartment.getDepartment(), employeeRole.getRole(), employee.getEmail(), employee.getPhoneNumber(), employee.getNumberAssigned(), employeeImages.getImage());


            spinner.setVisibility(View.GONE); // hide ProgressBar

            //saving the employee Id and the employee assigned number in the Application class
            MyApplication myApplication = (MyApplication) getApplication();
            myApplication.setEmployeeId(employeeId);
            myApplication.setEmployeeAssignedNumber(employeeAssignedNumber);


        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        // on back clicked go to EmployeesGridActivity with animation
        Intent goToEmployees = new Intent(EmployeeProfileActivity.this, EmployeesGridActivity.class);
        Bundle animation = ActivityOptions.makeCustomAnimation(
                getApplicationContext(), R.anim.animation, R.anim.animation2)
                .toBundle();
        startActivity(goToEmployees, animation);

    }

    // menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_without_search, menu);
        return true;
    }


    /**
     * On select action bar menu event
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {

            case R.id.settings:
                // settings event
                Toast.makeText(EmployeeProfileActivity.this, "settings", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.update:
                // update event
                Toast.makeText(EmployeeProfileActivity.this, "update", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.about:
                // about event
                Toast.makeText(EmployeeProfileActivity.this, "about", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.logout:
                // logout event
                Toast.makeText(EmployeeProfileActivity.this, "logout", Toast.LENGTH_SHORT)
                        .show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
