package com.example.go_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Go_AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_admin_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Go Bus");
//        actionBar.setSubtitle("Hello");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public void nextActivity01(View v){
        Intent i = new Intent(this, Go_AddBus.class);
        startActivity(i);
    }

    public void nextActivity02(View v){
        Intent i = new Intent(this, Go_BusDetails.class);
        startActivity(i);
    }


}