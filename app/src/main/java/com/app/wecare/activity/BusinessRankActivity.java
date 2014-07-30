package com.app.wecare.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.app.wecare.R;

/*
* this Activity will give the opportunity to add a comment to a rank given to a business
 */

public class BusinessRankActivity extends Activity {

    View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_rank_activity);
        // hiding putting to fullscreen
        decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
