package com.example.karan.gsautofinale.Products.CheckNuts;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.karan.gsautofinale.ProductModel;
import com.example.karan.gsautofinale.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CheckNutsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CheckNutsAdapter checkNutsAdapter;
    List<ProductModel> productModels;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_nuts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        database = FirebaseDatabase.getInstance();

        productModels = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        checkNutsAdapter = new CheckNutsAdapter(productModels,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GetFirebaseData();

        recyclerView.setAdapter(checkNutsAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void GetFirebaseData(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading data....");
        progressDialog.show();

        ref = database.getReference("data");
        ref.orderByKey().startAt("01").limitToFirst(43).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                progressDialog.dismiss();
                ProductModel productModel = dataSnapshot.getValue(ProductModel.class);
                productModels.add(productModel);
                checkNutsAdapter.notifyDataSetChanged();
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
