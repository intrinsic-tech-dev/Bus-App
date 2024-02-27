package com.example.go_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Go_UpdateBus extends AppCompatActivity {

    EditText txtID, txtDriver, txtConductor, txtVehicleNo, txtSeats;
    Button btnUpdate, btnDelete;
    DatabaseReference dbRef;
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_update_bus);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Update Buses");
//        actionBar.setSubtitle("Hello");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtDriver = findViewById(R.id.ed_01);
        txtConductor = findViewById(R.id.ed_02);
        txtVehicleNo = findViewById(R.id.ed_03);
        txtSeats = findViewById(R.id.ed_04);
        txtID = findViewById(R.id.ed_05);

        btnUpdate = findViewById(R.id.btn_07);
        btnDelete = findViewById(R.id.btn_save);

        bus = new Bus();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

        private void clearControls() {

            txtDriver.setText("");
            txtConductor.setText("");
            txtVehicleNo.setText("");
            txtSeats.setText("");
            txtID.setText("");
        }

        public void buttonUpdate(View view){
            DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Bus");

            readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChild("Bus1")){

                        try{

                            bus.setDriverName(txtDriver.getText().toString().trim());
                            bus.setConductorName(txtConductor.getText().toString().trim());
                            bus.setVehicleNo(txtVehicleNo.getText().toString().trim());
                            bus.setNoOfSeats(txtSeats.getText().toString().trim());
                            bus.setNoOfSeats(txtID.getText().toString().trim());

                            dbRef = FirebaseDatabase.getInstance().getReference().child("Bus").child("Bus1");
                            dbRef.setValue(bus);
                            clearControls();

                            Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Go_UpdateBus.this, Go_SaveBus.class));

                        }

                        catch (NumberFormatException e){
                            Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else
                        Toast.makeText(getApplicationContext(), "No Source to update", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }

    public void setButtonDelete(View view){

        String temp = txtID.getText().toString();
        int number = Integer.parseInt(temp);
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Bus").child(temp);

        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){

                    dbRef = FirebaseDatabase.getInstance().getReference().child("Bus").child(temp);
                    dbRef.removeValue();
                    clearControls();

                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Go_UpdateBus.this, Go_DeleteBus.class));

                }

                else
                    Toast.makeText(getApplicationContext(), "No Source to delete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}