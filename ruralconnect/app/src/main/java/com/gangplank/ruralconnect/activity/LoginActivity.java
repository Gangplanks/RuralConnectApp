package com.gangplank.ruralconnect.activity;

import android.content.Intent;
import android.app.Activity;

import android.os.Bundle;
import android.view.View;

import com.gangplank.ruralconnect.R;


public class LoginActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view) {
        Intent myIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(myIntent);
    }
}

