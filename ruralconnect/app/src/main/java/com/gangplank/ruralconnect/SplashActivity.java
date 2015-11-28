package com.gangplank.ruralconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

public class SplashActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String rural_connect_prefs = "RURAL_CONNECT_PREFS";
        final SharedPreferences sharedPreferences = getSharedPreferences(rural_connect_prefs, 0);
        String user_id = sharedPreferences.getString("user_id", "");

        ConnectivityManager conMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State mobile = conMan.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State wifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();

        if (mobile != NetworkInfo.State.CONNECTED && wifi != NetworkInfo.State.CONNECTED) {
            Toast.makeText(this, "No internet connection available. Please check your settings.", LENGTH_LONG).show();
            return;
        }



        if (user_id != null && !user_id.isEmpty()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }
    }

}
