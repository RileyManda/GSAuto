package com.example.karan.gsautofinale.Products.HubBoltWashers;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.karan.gsautofinale.ProductModelTwo;
import com.example.karan.gsautofinale.Products.Trailer.TrailerAdapter;
import com.example.karan.gsautofinale.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HubWashersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference ref;
    List<ProductModelTwo> productModelTwos;
    HubWashersAdapter hubWashersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_washers);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        database = FirebaseDatabase.getInstance();

        productModelTwos = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hubWashersAdapter = new HubWashersAdapter(productModelTwos,getApplicationContext());

        GetFirebaseData();

        recyclerView.setAdapter(hubWashersAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void GetFirebaseData(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading data....");
        progressDialog.show();

        ref = database.getReference("data");
        ref.orderByKey().startAt("1209").limitToFirst(9).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                progressDialog.dismiss();
                ProductModelTwo productModel = dataSnapshot.getValue(ProductModelTwo.class);
                productModelTwos.add(productModel);
                hubWashersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
