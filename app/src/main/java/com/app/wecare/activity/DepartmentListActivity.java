package com.app.wecare.activity;

/*
*This Activity display all departments in a custom ListView
*/


import android.app.ActionBar;
import android.app.ActivityOptions;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.wecare.R;
import com.app.wecare.dao.DepartmentDAO;
import com.app.wecare.dao.EmployeeDAO;
import com.app.wecare.model.Department;
import com.app.wecare.ui.DepartmentListAdapter;

import android.widget.AdapterView.OnItemClickListener;

import java.util.List;

public class DepartmentListActivity extends ListActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_list_activity);

        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        // AsyncTask to load and setup the department List
        new LoadDepartmentList().execute();


    }

    // menu
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_without_search, menu);
        return true;
    }

    // on menu item click method
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub


        Context context = view.getContext();

        TextView textViewItem = ((TextView) view.findViewById(R.id.tv_department_name));

        // get the clicked item name
        String listItemText = textViewItem.getText().toString();

        // get the clicked item ID
        String listItemId = textViewItem.getTag().toString();

        /*
        -   AsyncTask to check if department has employee
        -   Direct to the success Activity or display notification message
        */
        new OnDepartmentClickTask().execute(listItemId);

    }


    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        Intent goToEmployees = new Intent(DepartmentListActivity.this, SectionListActivity.class);
        Bundle animation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(),
                        R.anim.animation, R.anim.animation2).toBundle();
        startActivity(goToEmployees, animation);

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
                Toast.makeText(DepartmentListActivity.this, "settings", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.update:
                // update event
                Toast.makeText(DepartmentListActivity.this, "update", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.about:
                // about event
                Toast.makeText(DepartmentListActivity.this, "about", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.logout:
                // logout event
                Toast.makeText(DepartmentListActivity.this, "logout", Toast.LENGTH_SHORT)
                        .show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * AsyncTask to Load and show departments in a list
     */
    private class LoadDepartmentList extends
            AsyncTask<Void, Void, List<Department>> {

        protected ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            super.onPreExecute();
            progressDialog = ProgressDialog.show(DepartmentListActivity.this,
                    "Loading ....", "Please wait", true, false);


        }


        @Override
        protected List<Department> doInBackground(Void... none) {
            // load from the database
            DepartmentDAO department = new DepartmentDAO(DepartmentListActivity.this);
            department.open();
            try {

                List<Department> departments = department.getAllDepartments();

                return departments;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                department.close();
            }


            return null;
        }

        @Override
        protected void onPostExecute(List<Department> departments) {

            // UI thread to display the department in a custom list

            ListView listOfDepartment = (ListView) findViewById(android.R.id.list);
            DepartmentListAdapter adapter = new DepartmentListAdapter(DepartmentListActivity.this, R.layout.department_list_row, departments);

            ListView listViewItems = new ListView(DepartmentListActivity.this);
            listViewItems.setAdapter(adapter);

            listOfDepartment.setAdapter(adapter);
            listOfDepartment.setOnItemClickListener(DepartmentListActivity.this);

            // dismiss the progressDialog
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }
    }

    /**
     * AsyncTask to check if department has employee
     */
    private class OnDepartmentClickTask extends
            AsyncTask<String, Void, Boolean> {

        int departmentId;

        @Override
        protected Boolean doInBackground(String... id) {

            departmentId = Integer.parseInt(id[0]);
            EmployeeDAO employeeDAO = new EmployeeDAO(DepartmentListActivity.this);
            employeeDAO.open();
            try {

                return employeeDAO.CheckIfDepartmentHasEmployee(departmentId); // return true or false

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                employeeDAO.close();
            }

        }

        @Override
        protected void onPostExecute(Boolean employeeExist) {
            // check if department has employee or not and perform action
            if (employeeExist) {
                // go to EmployeesGridActivity
                Intent intent = new Intent(DepartmentListActivity.this, EmployeesGridActivity.class);
                Bundle animation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(),
                                R.anim.animation, R.anim.animation2).toBundle();
                String departId = Integer.toString(departmentId);
                intent.putExtra("departmentId", departId);
                startActivity(intent, animation);
            } else {
                // notification message
                Toast toast = Toast.makeText(DepartmentListActivity.this, "Sorry no employee founded", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        }
    }
}
