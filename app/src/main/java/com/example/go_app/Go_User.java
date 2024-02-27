package com.example.go_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Go_User extends AppCompatActivity {

    Button Confirm;
    TextView FinalTot;
    DatabaseReference dbRef;
    UserTicket tick;

    String strSeatList = "";
    String Final = "";

    int Tickid = 7999;

    EditText userid, useremail;
    ArrayList<Integer> seatSelect = new ArrayList<>();
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Confirm Your Ticket");
        //actionBar.setSubtitle("Hello");
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        FinalTot = findViewById(R.id.UserFinalAmount);
        Confirm = findViewById(R.id.UserConfirmButton);
        userid = findViewById(R.id.userid);
        useremail = findViewById(R.id.useremail);

        Intent intent = getIntent();

        Final = intent.getStringExtra("FinalTot");
        String Currency = intent.getStringExtra("Currency");
        seatSelect = (ArrayList<Integer>) intent.getSerializableExtra("seatSelect");


        for (int i = 0; i < seatSelect.size(); i++) {
            strSeatList += seatSelect.get(i) + ",";
        }

        System.out.println("Data Valuessssss = "+seatSelect);
        System.out.println("Data Values"+strSeatList);
        String Amount = Final + Currency;

        FinalTot.setText(Amount);
        
        tick = new UserTicket(); 


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }


    private void clearControls(){
        userid.setText("");
        useremail.setText("");
    }


    public void Payment(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("UserTicket");

        try{
            if (TextUtils.isEmpty(userid.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter User ID", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(useremail.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter User Email", Toast.LENGTH_SHORT).show();
            else {

                tick.setUserId(userid.getText().toString().trim());
                tick.setUserEmail(useremail.getText().toString().trim());
                tick.setSeatList(strSeatList);
                tick.setPrice(Final);

                Tickid++;
                String tickid = Integer.toString(Tickid);

                dbRef.child(tickid).setValue(tick);

                Toast.makeText(getApplicationContext(), "Your Ticket Booked", Toast.LENGTH_SHORT).show();
                clearControls();
                Intent intent2 = new Intent(Go_User.this, Go_TicketSuccess.class);
                intent2.putExtra("strSeatList", strSeatList);
                intent2.putExtra("TickNo", tickid);
                startActivity(intent2);

            }
            //Toast.makeText(getApplicationContext(), "Please enter an ID", Toast.LENGTH_SHORT).show();
        }

        catch (NumberFormatException e){

            Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();

        }



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.Profile:
                startActivity(new Intent(Go_User.this, Go_SeatBooking.class));
                Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.BusSearch:
                Toast.makeText(this, "Bus Search selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}