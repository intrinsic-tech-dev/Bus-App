package com.example.go_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Go_Feedback extends AppCompatActivity {

    Button button22;
    EditText feddback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        feddback = (EditText) findViewById(R.id.feddback);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_feedback);
        feddback = (EditText) findViewById(R.id.feddback);



        button22 = (Button) findViewById(R.id.button22);

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert();

            }
        });




    }

    private void processinsert()
    {

        Map<String,Object> map = new HashMap<>();
        map.put("feddback",feddback.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("feedback").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        feddback.setText("");
                        Toast.makeText(getApplicationContext(), "Add FeedBack Successfully", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(), "Add FeedBack NotVaild ", Toast.LENGTH_SHORT).show();


                    }
                });



    }
}







