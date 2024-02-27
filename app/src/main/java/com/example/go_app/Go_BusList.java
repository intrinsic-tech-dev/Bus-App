package com.example.go_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Go_BusList extends AppCompatActivity {

    private String EnterStart;
    private String EnterEnd;
    private String TripDate;
    ListView listView;

    Button BtnArrow;

    BusAdaptor adaptor;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busroute_layout);

        BtnArrow = findViewById(R.id.BtnArrow);

        listView = findViewById(R.id.BusList);
        Intent intent = getIntent();

        EnterStart = intent.getStringExtra("EnterStart");
        EnterEnd = intent.getStringExtra("EnterEnd");
        TripDate = intent.getStringExtra("TripDate");




        final ArrayList<BusRoute> list = new ArrayList<>();
        //final ArrayAdapter adapter = new ArrayAdapter<BusRoute>(this, R.layout.activity_go_bus_list);
        //listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Route");
        reference.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                list.clear();
                                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                                                    BusRoute busroute = snapshot.getValue(BusRoute.class);
                                                    //String name = busroute.getBusNumber();
                                                    list.add(busroute);

                                                }
                                                adaptor = new BusAdaptor(Go_BusList.this, list);
                                                listView.setAdapter(adaptor);
                                                //adapter.notifyDataSetChanged();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        }

        );

    }

    public void List(View view) {

        startActivity(new Intent(Go_BusList.this, Go_BusSeatSelect.class));

    }


}