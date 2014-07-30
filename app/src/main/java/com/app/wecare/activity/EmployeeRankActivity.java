package com.app.wecare.activity;


/*
* This activity is used to rank the employee ( Rank = click on Poor , Average or Good)
 */

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.wecare.R;
import com.app.wecare.dao.EmployeeDAO;
import com.app.wecare.model.Employee;
import com.app.wecare.model.EmployeeImage;
import com.app.wecare.model.EmployeeRole;


public class EmployeeRankActivity extends Activity implements View.OnClickListener {

    private LinearLayout lPoor, lAverage, lGood;
    private MediaPlayer beepSound;
    private ImageView employeeImageView;
    private TextView employeeName, employeeRoleName;
    private ProgressBar spinner;
    private View decorView;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_rank_activity);
        // hiding putting to fullscreen
        decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // <for full screen mode> - - -
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        // </for full screen mode> - - -

        beepSound = MediaPlayer.create(EmployeeRankActivity.this, R.raw.onranksound);

        // getting employee Id

        Intent intent = getIntent();
        String employeeId = intent.getExtras().getString("employeeId");

//        Toast.makeText(getApplicationContext(), "Id " + employeeId,
//                Toast.LENGTH_SHORT).show();


        initializer();
        new ShowEmployee().execute(employeeId);


    }

    // variable initialization
    public void initializer() {

        lPoor = (LinearLayout) findViewById(R.id.llPoor);
        lAverage = (LinearLayout) findViewById(R.id.llAverage);
        lGood = (LinearLayout) findViewById(R.id.llGood);
        employeeImageView = (ImageView) findViewById(R.id.ivEmployeeImage);
        employeeName = (TextView) findViewById(R.id.tvEmployeeName);
        employeeRoleName = (TextView) findViewById(R.id.tvEmployeeRole);
        spinner = (ProgressBar) findViewById(R.id.progressBar);

        lPoor.setOnClickListener(this);
        lAverage.setOnClickListener(this);
        lGood.setOnClickListener(this);
    }

    // setting the layout
    public void setGUI(String name, String role, Bitmap image) {

        employeeName.setText(name);
        employeeRoleName.setText(role);
        employeeImageView.setImageBitmap(image); // image

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            // on Poor button pressed
            case R.id.llPoor:
                beepSound.start(); // sound beep
                dialog = new Dialog(EmployeeRankActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_yes_or_no_comment);
                Button yes = (Button) dialog.findViewById(R.id.btYesComment);
                Button no = (Button) dialog.findViewById(R.id.btNoComment);
                yes.setOnClickListener(EmployeeRankActivity.this);
                no.setOnClickListener(EmployeeRankActivity.this);

                dialog.show();
                break;

            // on Average button pressed
            case R.id.llAverage:
                beepSound.start(); // sound beep
                dialog = new Dialog(EmployeeRankActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_yes_or_no_comment);
                yes = (Button) dialog.findViewById(R.id.btYesComment);
                no = (Button) dialog.findViewById(R.id.btNoComment);
                yes.setOnClickListener(EmployeeRankActivity.this);
                no.setOnClickListener(EmployeeRankActivity.this);

                dialog.show();
                break;

            // on Good button pressed
            case R.id.llGood:
                beepSound.start(); // sound beep
                dialog = new Dialog(EmployeeRankActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_yes_or_no_comment);
                yes = (Button) dialog.findViewById(R.id.btYesComment);
                no = (Button) dialog.findViewById(R.id.btNoComment);
                yes.setOnClickListener(EmployeeRankActivity.this);
                no.setOnClickListener(EmployeeRankActivity.this);

                dialog.show();
                break;

            // on Yes comment button pressed
            case R.id.btYesComment:

                Intent intent = new Intent(EmployeeRankActivity.this, CommentActivity.class);

                Bundle animation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(),
                                R.anim.animation, R.anim.animation2).toBundle();
                startActivity(intent, animation);

                dialog.hide();


                break;

            // on No comment button pressed
            case R.id.btNoComment:

                Toast toast = Toast.makeText(getApplicationContext(), "Thank you for Ranking our service", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                dialog.hide();

                break;
        }

    }

    /**
     * AsyncTask to load and show an employee
     */
    private class ShowEmployee extends
            AsyncTask<String, Void, Employee> {

        EmployeeImage employeeImages;
        EmployeeRole employeeRole;
        int employeeId;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            super.onPreExecute();

            spinner.setVisibility(View.VISIBLE); // show ProgressBar

        }

        @Override
        protected Employee doInBackground(String... hm) {
            EmployeeDAO employeeDAO = new EmployeeDAO(EmployeeRankActivity.this);

            employeeDAO.open();
            employeeId = Integer.parseInt(hm[0]);
            try {

                Employee employee = employeeDAO.getEmployeeById(employeeId);
                employeeImages = employeeDAO.getEmployeeImage(employee);
                employeeRole = employeeDAO.getEmployeeRole(employee);


                return employee;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employeeDAO.close();
            }


            return null;

        }

        @Override
        protected void onPostExecute(Employee employee) {
            String name = employee.getFirstName() + " " + employee.getLastName();
            String role = employeeRole.getRole();

            Bitmap image = employeeImages.getImage(); // image

            // setting the layout
            setGUI(name, role, image);
            spinner.setVisibility(View.GONE); // hide ProgressBar


        }
    }
}
