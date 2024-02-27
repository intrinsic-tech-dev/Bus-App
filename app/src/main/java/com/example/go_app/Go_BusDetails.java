package com.example.go_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Go_BusDetails extends AppCompatActivity {

    EditText txtID, txtDriver, txtConductor, txtVehicleNo, txtSeats;
    Button btnView;
    DatabaseReference dbRef;
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_bus_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search Bus");
//        actionBar.setSubtitle("Hello");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtDriver = findViewById(R.id.ed_01);
        txtConductor = findViewById(R.id.ed_02);
        txtVehicleNo = findViewById(R.id.ed_03);
        txtSeats = findViewById(R.id.ed_04);
        txtID = findViewById(R.id.ed_05);

        btnView = findViewById(R.id.btn_view);

        bus = new Bus();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }


    public void busView(View view){

        String temp = txtID.getText().toString();
        int number = Integer.parseInt(temp);
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Bus").child(temp);

        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){

                    txtDriver.setText(dataSnapshot.child("Driver Name").getValue().toString());
                    txtConductor.setText(dataSnapshot.child("Conductor Name").getValue().toString());
                    txtVehicleNo.setText(dataSnapshot.child("Vehicle Number").getValue().toString());
                    txtSeats.setText(dataSnapshot.child("No of Seats").getValue().toString());
                }

                else
                    Toast.makeText(getApplicationContext(), "No Source to display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}