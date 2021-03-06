package com.gangplank.ruralconnect.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.gangplank.ruralconnect.R;
import com.gangplank.ruralconnect.fragment.AboutFragment;
import com.gangplank.ruralconnect.fragment.MySchemeFragment;
import com.gangplank.ruralconnect.fragment.ReviewFragment;
import com.gangplank.ruralconnect.fragment.SchemeFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Bundle myBundle = new Bundle();

    FragmentManager fragmentManager1 = getFragmentManager();
    FragmentManager fragmentManager2 = getFragmentManager();
    ReviewFragment reviewFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager1.beginTransaction()
                .replace(R.id.frame_container, new MySchemeFragment()).commit();

        setTitle("My Scheme");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void viewScheme(View view) {
        reviewFragment = new ReviewFragment();
        TextView textView = (TextView) view.findViewById(R.id.content);
        this.myBundle.putInt("scheme_id", (Integer) textView.getTag());
        fragmentManager1.beginTransaction()
                .replace(R.id.frame_container, new SchemeFragment()).commit();
        fragmentManager2.beginTransaction().replace(R.id.frame_container1,reviewFragment).commit();

        setTitle("Scheme");

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        fragmentManager2.beginTransaction().remove(reviewFragment).commit();
        if (id == R.id.nav_myScheme) {
            fragment = new MySchemeFragment();
        } else if (id == R.id.nav_findScheme) {
            fragment = new AboutFragment();
        } else if (id == R.id.nav_manage) {
            fragment = new AboutFragment();
        } else if (id == R.id.nav_about) {
            fragment = new AboutFragment();
        } else if (id == R.id.nav_logout) {
            fragment = new AboutFragment();
        }
        if (fragment != null) {

            fragmentManager1.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            setTitle(item.getTitle());
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
        return true;
    }
}
