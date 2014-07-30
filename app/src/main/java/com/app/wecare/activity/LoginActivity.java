package com.app.wecare.activity;
/*
* login Activity is here
 */

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.wecare.R;
import com.app.wecare.dao.EmployeeDAO;

import java.util.Calendar;


public class LoginActivity extends Activity implements View.OnClickListener {

    EditText emailET, passwordET;
    String email, password;
    Button login;
    TextView loginErrorMessage, copyright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initializer();
    }

    //  variable  initialization  method
    private void initializer() {
        // TODO Auto-generated method stub

        // link variable to Resource
        emailET = (EditText) findViewById(R.id.etEmail);
        passwordET = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.bLogin);
        loginErrorMessage = (TextView) findViewById(R.id.tvLoginError);
        copyright = (TextView) findViewById(R.id.tvFooter);


        // getting the year and setting the copyright to the current year
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String copyrightText = "Copyright \u00a9 " + year
                + " by [Company name] All Rights reserved";
        copyright.setText(copyrightText);
        login.setOnClickListener(this);

    }

    // onclick event
    @Override
    public void onClick(View click) {
        // TODO Auto-generated method stub
        switch (click.getId()) {
            case R.id.bLogin:

                // if login clicked call a background class to check for login
                new PasswordCheck().execute();
                break;

        }

    }

    /**
     * AsyncTask to check for login and direct to either success Activity  or display error message
     */
    private class PasswordCheck extends
            AsyncTask<Void, Void, Boolean> {


        @Override
        protected Boolean doInBackground(Void... none) {

            EmployeeDAO employee = new EmployeeDAO(LoginActivity.this);
            try {
                employee.open();
                // get the text from the EditText
                email = emailET.getText().toString();
                password = passwordET.getText().toString();

                if (employee.checkLogin(email, password)) {
                    return true;
                } else {
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                employee.close();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Boolean loginCheck) {


            if (loginCheck) {
                // login successfully
                Intent intent = new Intent(LoginActivity.this, SectionListActivity.class);
                Bundle animation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(),
                                R.anim.animation, R.anim.animation2).toBundle();
                startActivity(intent, animation);

            } else {
                // login error
                loginErrorMessage
                        .setText("The username or password is incorrect");

            }


        }
    }


}
