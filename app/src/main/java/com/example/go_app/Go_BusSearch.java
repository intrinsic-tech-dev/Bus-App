package com.example.go_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Go_BusSearch extends AppCompatActivity {

    EditText EnterStartLocation;
    EditText EnterEndLocation;
    EditText TripDate;

    DatePickerDialog.OnDateSetListener setListener;

    Button BtnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_bus_search);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search Bus");
        //actionBar.setSubtitle("Hello");
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        EnterStartLocation = findViewById(R.id.EnterStartLocation);
        EnterEndLocation = findViewById(R.id.EnterEndLocation);
        EnterEndLocation = findViewById(R.id.EnterEndLocation);
        TripDate = findViewById(R.id.Tripdate);
        BtnSearch = findViewById(R.id.BusSearch);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public void BusSearch(View view){

        String EnterStart = EnterStartLocation.getText().toString();
        String EnterEnd = EnterEndLocation.getText().toString();
        String TDate = TripDate.getText().toString();

        try{
            if (TextUtils.isEmpty(EnterStart))
                Toast.makeText(getApplicationContext(), "Please enter an Start Location", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(EnterEnd))
                Toast.makeText(getApplicationContext(), "Please enter an End Location", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(TDate))
                Toast.makeText(getApplicationContext(), "Please enter an Trip Date", Toast.LENGTH_SHORT).show();
            else {

//                System.out.println(EnterEnd);
//                System.out.println(EnterStart);
//                System.out.println(TDate);

                Intent intent = new Intent(Go_BusSearch.this, Go_BusList.class);

                intent.putExtra("EnterStart", EnterStart);
                intent.putExtra("EnterEnd", EnterEnd);
                intent.putExtra("TripDate", TDate);

                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Loading Bus List", Toast.LENGTH_SHORT).show();

            }
        }

        catch (NumberFormatException e){

            Toast.makeText(getApplicationContext(), "Please enter details correctly", Toast.LENGTH_SHORT).show();

        }

    }

    public void SelectDate1(View view){

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Go_BusSearch.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date = day+"/"+month+"/"+year;
                TripDate.setText(date);

            }
        }, year, month, day );
        datePickerDialog.show();

    }
}