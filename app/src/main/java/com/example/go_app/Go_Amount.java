package com.example.go_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Go_Amount extends AppCompatActivity {

    TextView NoSeats;
    TextView PerPrice;
    TextView FinalAmount;
    private int Price = 400;
    private int Total = 0;
    private int Seats = 0;
    String FinalTot;
    String Currency = " LKR";
    ArrayList<Integer> seatSelect = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_amount);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Amount of Your Ticket");
        //actionBar.setSubtitle("Hello");
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        NoSeats = findViewById(R.id.NoSeats);
        PerPrice = findViewById(R.id.PerPrice);
        FinalAmount = findViewById(R.id.UserFinalAmount);

        Intent intent = getIntent();

        String NoSeat = intent.getStringExtra("NoSeat");
        seatSelect = (ArrayList<Integer>) intent.getSerializableExtra("selectSeats");
        //seatSelect = intent.getParcelableExtra("selectSeats");
        System.out.println("Data Values"+seatSelect);

        NoSeats.setText(NoSeat);

        Seats =  Integer.parseInt(NoSeat);

        Total = Price*Seats;

        FinalTot = Integer.toString(Total);
        Currency = " LKR";
        String FinalValue = FinalTot + Currency;

        FinalAmount.setText(FinalValue);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public void Gonext(View view){

        Intent intent = new Intent(Go_Amount.this, Go_User.class);
        intent.putExtra("FinalTot", FinalTot);
        intent.putExtra("Currency", Currency);
        intent.putExtra("seatSelect", seatSelect);
        startActivity(intent);

    }
}