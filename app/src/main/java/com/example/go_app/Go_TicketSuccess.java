package com.example.go_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Go_TicketSuccess extends AppCompatActivity {

    Button BtnUpdate, BtRemove;

    TextView SeatsNumber;
    private String strSeatList;
    //private int TickNo;
    private String TickNo;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_ticket_success);

        Intent intent = getIntent();
        strSeatList = intent.getStringExtra("strSeatList");
        TickNo = intent.getStringExtra("TickNo");

        System.out.println(TickNo);
        SeatsNumber = findViewById(R.id.SeatsNumber);

        SeatsNumber.setText(strSeatList);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Your Ticket Details");
        //actionBar.setSubtitle("Hello");
        //actionBar.setIcon(R.drawable.bluebus);
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public void BtnUpdate(View view) {

        startActivity(new Intent(Go_TicketSuccess.this, Go_BusSeatSelect.class));

    }

    public void BtnRemove(View view) {
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child("TickNo");

        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){

                    dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child("TickNo");
                    dbRef.removeValue();

                    Toast.makeText(getApplicationContext(), "Ticket Removed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Go_TicketSuccess.this, Go_SeatBooking.class));


                }

                else
                    Toast.makeText(getApplicationContext(), "No Source to delete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void NextPayment(View view){



    }
}