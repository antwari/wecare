package com.app.wecare.activity;


/*
    *This Activity serve as a List Menu
 */

import android.app.ActivityOptions;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.app.wecare.R;
import com.app.wecare.util.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;

import android.widget.AdapterView.OnItemClickListener;


public class SectionListActivity extends ListActivity implements OnItemClickListener {

    HashMap<String, String> map; // map of menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_list_activity);

        ListView listOfDepartment = (ListView) findViewById(android.R.id.list);

        ArrayList<HashMap<String, String>> menuList = new ArrayList<HashMap<String, String>>();


        map = new HashMap<String, String>();

        // adding each child node to HashMap key => value
        map.put("menu_name", "Rank Employee");
        menuList.add(map);

        map = new HashMap<String, String>();

        map.put("menu_name", "Rank Business");
        menuList.add(map);

        map = new HashMap<String, String>();

        map.put("menu_name", "Employee List");
        menuList.add(map);

        try {

            // adapt the list
            ListAdapter adapter = new SimpleAdapter(this, menuList,
                    R.layout.section_list_row, new String[]{"menu_name"},
                    new int[]{R.id.tvSectionName});

            listOfDepartment.setAdapter(adapter);
            listOfDepartment.setOnItemClickListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // onclick event here
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub


        if (position == 0) {

            // go to DepartmentListActivity

            MyApplication myApplication = (MyApplication) getApplication();
            myApplication.setGoToRAnkActivity(true);

            Intent goToDepartment = new Intent(SectionListActivity.this, DepartmentListActivity.class);
            Bundle animation =
                    ActivityOptions.makeCustomAnimation(getApplicationContext(),
                            R.anim.animation, R.anim.animation2).toBundle();
            startActivity(goToDepartment, animation);

        } else if (position == 1) {

            // go to BusinessRankActivity
            Intent gotoBusinessRAnkActivity = new Intent(SectionListActivity.this, BusinessRankActivity.class);
            Bundle animation =
                    ActivityOptions.makeCustomAnimation(getApplicationContext(),
                            R.anim.animation, R.anim.animation2).toBundle();
            startActivity(gotoBusinessRAnkActivity, animation);

        } else {
            // go to DepartmentListActivity

            MyApplication myApplication = (MyApplication) getApplication();
            myApplication.setGoToRAnkActivity(false);


            Intent goToDepartment = new Intent(SectionListActivity.this, DepartmentListActivity.class);
            Bundle animation =
                    ActivityOptions.makeCustomAnimation(getApplicationContext(),
                            R.anim.animation, R.anim.animation2).toBundle();
            startActivity(goToDepartment, animation);
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_without_search, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /**
     * On selecting action bar menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each menu item click
        switch (item.getItemId()) {

            case R.id.settings:
                // settings event
                Toast.makeText(SectionListActivity.this, "settings", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.update:
                // update event
                Toast.makeText(SectionListActivity.this, "update", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.about:
                // about event
                Toast.makeText(SectionListActivity.this, "about", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.logout:
                // logout event
                Toast.makeText(SectionListActivity.this, "logout", Toast.LENGTH_SHORT)
                        .show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
