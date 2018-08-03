package com.example.karan.gsautofinale.Products.SpringCenter;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.karan.gsautofinale.ProductModel;
import com.example.karan.gsautofinale.ProductModelTwo;
import com.example.karan.gsautofinale.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SpringCenterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference ref;
    List<ProductModelTwo> productModelTwos;
    SpringCenterAdapter springCenterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_center);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        database = FirebaseDatabase.getInstance();

        productModelTwos = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        springCenterAdapter = new SpringCenterAdapter(productModelTwos,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GetFirebase();

        recyclerView.setAdapter(springCenterAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void GetFirebase(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading data....");
        progressDialog.show();

        ref = database.getReference("data");
        ref.orderByKey().startAt("217").limitToFirst(96).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                progressDialog.dismiss();
                ProductModelTwo productModel = dataSnapshot.getValue(ProductModelTwo.class);
                productModelTwos.add(productModel);
                springCenterAdapter.notifyDataSetChanged();
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
