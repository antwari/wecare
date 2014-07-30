package com.app.wecare.activity;

/*
*This activity loads and displays employees of a selected department
* Each Employee must have his own image (images will be downloaded and stored on a local directory)
*/

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.wecare.R;
import com.app.wecare.dao.EmployeeDAO;
import com.app.wecare.model.Employee;
import com.app.wecare.model.EmployeeImage;
import com.app.wecare.model.EmployeeRole;
import com.app.wecare.ui.EmployeesGridAdapter;
import com.app.wecare.util.MyApplication;

import java.util.List;

public class EmployeesGridActivity extends Activity implements AdapterView.OnItemClickListener,
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private Menu menu;
    private SearchView searchView;
    List<EmployeeImage> employeeImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employees_grid_activity);

        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        String departmentId;
        if (getIntent().getExtras() != null) {
            // if the previous activity is DepartmentList
            Intent i = getIntent();
            departmentId = i.getStringExtra("departmentId");
        } else {
            // if the previous activity is the current Activity
            MyApplication myApplication = (MyApplication) getApplication();
            departmentId = myApplication.getDepartmentId() + " ";
            departmentId = departmentId.trim();

        }

        //AsyncTask to load employee data into a GridView
        new EmployeeLoaderTask().execute(departmentId);


    }


    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        // on back clicked go to DepartmentListActivity with animation

        Intent goToEmployees = new Intent(EmployeesGridActivity.this, DepartmentListActivity.class);
        Bundle animation = ActivityOptions.makeCustomAnimation(
                getApplicationContext(), R.anim.animation, R.anim.animation2)
                .toBundle();
        startActivity(goToEmployees, animation);

    }

    // menu
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_with_search, menu);
        //
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));


        searchView.setOnQueryTextListener(this);

        searchView.setOnCloseListener(this);

        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each menu item click
        switch (item.getItemId()) {
            case R.id.action_search:
                // search event
                Toast.makeText(EmployeesGridActivity.this, "search", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.setgs:
                // settings event
                Toast.makeText(EmployeesGridActivity.this, "settings !!!", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.upd:
                // update event
                Toast.makeText(EmployeesGridActivity.this, "update here !!!",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.abt:
                // about event
                Toast.makeText(EmployeesGridActivity.this, "about !!!", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.lgt:
                // logout event
                Toast.makeText(EmployeesGridActivity.this, "logged out safely!!!",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // method called when you click on submit in searching
    @Override
    public boolean onQueryTextSubmit(String query) {


        final int minQueryChars = getResources().getInteger(R.integer.min_query_chars); // minimum character in order to start the search
        if (query.length() > minQueryChars) {
            new DoSearch().execute(query.toString());  // AsyncTask to load employees matching the search condition in a GridView
        }

        return true;
    }

    // method called when you write something in the search
    @Override
    public boolean onQueryTextChange(String query) {
        final int minQueryChars = getResources().getInteger(R.integer.min_query_chars);// minimum character in order to start the search
        final int zeroChar = getResources().getInteger(R.integer.zero_char);
        if (query.length() > minQueryChars) {
            new DoSearch().execute(query.toString()); // AsyncTask to load employees matching the search condition in a GridView
        }


        if (query.length() == zeroChar) {
            // if you clear all text in the search  , reload employees of a selected department in a GridView
            MyApplication myApplication = (MyApplication) getApplication();
            String departmentId = " " + myApplication.getDepartmentId();
            departmentId = departmentId.trim();
            new OnCancelEmployeeLoaderTask().execute(departmentId);
        }

        return true;
    }

    // method called when SearchView is closed
    @Override
    public boolean onClose() {
        // if the search is closed do this
//        Toast.makeText(getApplicationContext(), "closed now !!", Toast.LENGTH_SHORT).show();
        MyApplication myApplication = (MyApplication) getApplication();
        String departmentId = " " + myApplication.getDepartmentId();
        departmentId = departmentId.trim();
        new OnCancelEmployeeLoaderTask().execute(departmentId); // AsyncTask to reload employees in a GridView
        return false;
    }

    /**
     * AsyncTask to load employees matching the search condition in a GridView
     */
    private class DoSearch extends
            AsyncTask<String, Void, List<Employee>> {


        List<EmployeeRole> employeeRoles;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            super.onPreExecute();


        }

        // background Thread
        @Override
        protected List<Employee> doInBackground(String... hm) {

            EmployeeDAO employeeDAO = new EmployeeDAO(EmployeesGridActivity.this);

            employeeDAO.open();

            MyApplication myApplication = (MyApplication) getApplication();

            int departmentId = myApplication.getDepartmentId(); // department must come from somewhere
            String query = hm[0];

            try {

                List<Employee> employees = employeeDAO.getEmployeesByDepartmentIdAndSearchKeyword(departmentId, query);
                employeeImages = employeeDAO.getAllEmployeesImages(employees);
                employeeRoles = employeeDAO.getEmployeesRoles(employees);

                System.out.print("employees : " + employees.size() + " images : " + employeeImages.size() + "");


                return employees;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employeeDAO.close();
            }


            return null;

        }

        // UI thread
        @Override
        protected void onPostExecute(List<Employee> employees) {
            final GridView gView1 = (GridView) findViewById(R.id.gridView1);
            EmployeesGridAdapter adapter = new EmployeesGridAdapter(EmployeesGridActivity.this, R.layout.employees_grid_item, employees, employeeImages, employeeRoles);

            gView1.setAdapter(adapter);
            gView1.setOnItemClickListener(EmployeesGridActivity.this);


        }
    }


    /**
     * AsyncTask to reload employees in a GridView
     */
    private class OnCancelEmployeeLoaderTask extends
            AsyncTask<String, Void, List<Employee>> {

        List<EmployeeRole> employeeRoles;
        int departId;


        // background Thread
        @Override
        protected List<Employee> doInBackground(String... hm) {
            EmployeeDAO employeeDAO = new EmployeeDAO(EmployeesGridActivity.this);

            employeeDAO.open();
            departId = Integer.parseInt(hm[0]);
            try {

                List<Employee> employees = employeeDAO.getEmployeesByDepartmentId(departId);
                employeeImages = employeeDAO.getAllEmployeesImages(employees);
                employeeRoles = employeeDAO.getEmployeesRoles(employees);

                return employees;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employeeDAO.close();
            }


            return null;

        }

        // UI Thread
        @Override
        protected void onPostExecute(List<Employee> employees) {
            final GridView gView1 = (GridView) findViewById(R.id.gridView1);
            EmployeesGridAdapter adapter = new EmployeesGridAdapter(EmployeesGridActivity.this, R.layout.employees_grid_item, employees, employeeImages, employeeRoles);

            gView1.setAdapter(adapter);
            gView1.setOnItemClickListener(EmployeesGridActivity.this);


            // set departmentId from the Application class

            MyApplication myApplication = (MyApplication) getApplication();
            myApplication.setDepartmentId(departId);


        }
    }


    /**
     * AsyncTask to load employee data into a GridView
     */
    private class EmployeeLoaderTask extends
            AsyncTask<String, Void, List<Employee>> {

        protected ProgressDialog progressDialog;
        //        List<EmployeeImage> employeeImages;
        List<EmployeeRole> employeeRoles;
        int departId;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            super.onPreExecute();

            progressDialog = ProgressDialog.show(EmployeesGridActivity.this,
                    "Loading ....", "Please wait", true, false);

        }

        @Override
        protected List<Employee> doInBackground(String... hm) {
            EmployeeDAO employeeDAO = new EmployeeDAO(EmployeesGridActivity.this);

            employeeDAO.open();
            departId = Integer.parseInt(hm[0]);
            try {

                List<Employee> employees = employeeDAO.getEmployeesByDepartmentId(departId);
                employeeImages = employeeDAO.getAllEmployeesImages(employees);
                employeeRoles = employeeDAO.getEmployeesRoles(employees);

                return employees;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employeeDAO.close();
            }


            return null;

        }

        @Override
        protected void onPostExecute(List<Employee> employees) {
            final GridView gView1 = (GridView) findViewById(R.id.gridView1);
            EmployeesGridAdapter adapter = new EmployeesGridAdapter(EmployeesGridActivity.this, R.layout.employees_grid_item, employees, employeeImages, employeeRoles);

            gView1.setAdapter(adapter);
            gView1.setOnItemClickListener(EmployeesGridActivity.this);


            // set departmentId from the application class

            MyApplication myApplication = (MyApplication) getApplication();
            myApplication.setDepartmentId(departId);

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    // On GridView item selected
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub


        Context context = view.getContext();

        TextView employee = ((TextView) view.findViewById(R.id.tv_employee_name));

        // get the clicked item name
        String employeeName = employee.getText().toString();

        // get the clicked item ID
        String employeeId = employee.getTag().toString();

        MyApplication myApplication = (MyApplication) getApplication();


        // detect where to go when clicked on the grid , whether  EmployeeRankActivity or EmployeeProfileActivity
        if (myApplication.getGoToRAnkActivity()) {

            // go to EmployeeRankActivity with animation
            Intent intent = new Intent(EmployeesGridActivity.this, EmployeeRankActivity.class);

            Bundle animation =
                    ActivityOptions.makeCustomAnimation(getApplicationContext(),
                            R.anim.animation, R.anim.animation2).toBundle();
            intent.putExtra("employeeId", employeeId);
            startActivity(intent, animation);

        } else {

            // go to EmployeeProfileActivity with animation
            Intent intent = new Intent(EmployeesGridActivity.this, EmployeeProfileActivity.class);

            Bundle animation =
                    ActivityOptions.makeCustomAnimation(getApplicationContext(),
                            R.anim.animation, R.anim.animation2).toBundle();
            intent.putExtra("employeeId", employeeId);
            startActivity(intent, animation);


        }

    }
}
