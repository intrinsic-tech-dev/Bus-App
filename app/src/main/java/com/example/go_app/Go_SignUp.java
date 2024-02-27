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

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
//
public class Go_SignUp extends AppCompatActivity {
    EditText username,personalid,phonenumber,email,password;
    Button submit;
    DatabaseReference dbRef;
    User user;
    //

    private int userID =999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_sign_up);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register");
        //actionBar.setSubtitle("Hello");
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        username=findViewById(R.id.user_personal);
        personalid=findViewById(R.id.user_personal);
        phonenumber=findViewById(R.id.editTextTextPersonName2);
        email=findViewById(R.id.editTextTextPersonName8);
        password=findViewById(R.id.editTextTextPersonName8);
        submit=findViewById(R.id.button);
        user=new User();
    }
    //

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
 private void clearControls(){
     username.setText("");
     personalid.setText("");
     phonenumber.setText("");
     email.setText("");
     password.setText("");
 }
 public void buttonSubmit(View view){
        dbRef= FirebaseDatabase.getInstance().getReference().child("User");
        try {
            if (TextUtils.isEmpty(username.getText().toString()))
                Toast.makeText(getApplicationContext(), "please enter user name", Toast.LENGTH_SHORT).show();

            else if (TextUtils.isEmpty(personalid.getText().toString()))
                Toast.makeText(getApplicationContext(), "please enter Personal ID", Toast.LENGTH_SHORT).show();

            else if (TextUtils.isEmpty(phonenumber.getText().toString()))
                Toast.makeText(getApplicationContext(), "please enter Phone number", Toast.LENGTH_SHORT).show();

            else if (TextUtils.isEmpty(email.getText().toString()))
                Toast.makeText(getApplicationContext(), "please enter E-mail", Toast.LENGTH_SHORT).show();

            else if (TextUtils.isEmpty(password.getText().toString()))
                Toast.makeText(getApplicationContext(), "please enter Password", Toast.LENGTH_SHORT).show();
            else {
                user.setUserName(username.getText().toString().trim());
                user.setPersonalID(personalid.getText().toString().trim());
                user.setPhoneNumber(phonenumber.getText().toString().trim());
                user.setEmail(email.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());

                userID++;
                int id1 = userID;
                String UserID = Integer.toString(id1);
                dbRef.child(UserID).setValue(user);
                Toast.makeText(getApplicationContext(), "Data save Successfully", Toast.LENGTH_SHORT).show();

                clearControls();

                //page link
                startActivity(new Intent(Go_SignUp.this, Go_ViewProfile.class));
            }
            Toast.makeText(getApplicationContext(), "please enter data", Toast.LENGTH_SHORT).show();
        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"invalid data",Toast.LENGTH_SHORT).show();
        }
 }
}