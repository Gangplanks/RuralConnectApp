package com.gangplank.ruralconnect.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gangplank.ruralconnect.R;

public class RegistrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

    }

    public void login(View view) {
        Intent myIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(myIntent);
    }
}
