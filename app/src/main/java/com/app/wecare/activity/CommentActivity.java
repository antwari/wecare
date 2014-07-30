package com.app.wecare.activity;

import android.app.Activity;
import android.os.Bundle;

import com.app.wecare.R;

/*
* this Activity will give the opportunity to add a comment to a rank given to an employee
 */


public class CommentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_activity);
    }
}
