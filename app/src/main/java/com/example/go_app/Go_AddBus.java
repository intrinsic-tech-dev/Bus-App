package com.example.go_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Go_AddBus extends AppCompatActivity {

    EditText txtDriver, txtConductor, txtVehicleNo, txtSeats;
    Button btnSave;
    DatabaseReference dbRef;
    Bus bus;

    private int BusID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_add_bus);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Buses");
//        actionBar.setSubtitle("Hello");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtDriver = findViewById(R.id.ed_01);
        txtConductor = findViewById(R.id.ed_02);
        txtVehicleNo = findViewById(R.id.ed_03);
        txtSeats = findViewById(R.id.ed_04);

        btnSave = findViewById(R.id.btn_save);

        bus = new Bus();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void clearControls(){

        txtDriver.setText("");
        txtConductor.setText("");
        txtVehicleNo.setText("");
        txtSeats.setText("");
    }

        public void buttonSave(View view) {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Bus");

            try {
                if (TextUtils.isEmpty(txtDriver.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter driver name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtConductor.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter conductor name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtVehicleNo.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter vehicle number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtSeats.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter no of seats", Toast.LENGTH_SHORT).show();
                else {

                    bus.setDriverName(txtDriver.getText().toString().trim());
                    bus.setConductorName(txtConductor.getText().toString().trim());
                    bus.setVehicleNo(txtVehicleNo.getText().toString().trim());
                    bus.setNoOfSeats(txtSeats.getText().toString().trim());

                    BusID++;
                    int id1 = BusID;
                    String  Busid = Integer.toString(id1);

                    dbRef.child(Busid).setValue(bus);

                    Toast.makeText(getApplicationContext(), "Data saved Successfully!", Toast.LENGTH_SHORT).show();
                    clearControls();
                    startActivity(new Intent(Go_AddBus.this, Go_SaveBus.class));
                }
                Toast.makeText(getApplicationContext(), "Please Enter Data!", Toast.LENGTH_SHORT).show();
            }

            catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Invalid Data!", Toast.LENGTH_SHORT).show();
                }
            }
}