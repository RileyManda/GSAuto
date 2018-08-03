package com.example.karan.gsautofinale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView tvDetailCode,tvDetailSize,tvDetailModel,tvDetailPrice,tvDetailApps,tvDetailInch;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvDetailCode = (TextView) findViewById(R.id.tvDetailCode);
        tvDetailSize = (TextView) findViewById(R.id.tvDetailSize);
        tvDetailModel = (TextView) findViewById(R.id.tvDetailModel);
        tvDetailPrice = (TextView) findViewById(R.id.tvDetailPrice);
        tvDetailApps = (TextView) findViewById(R.id.tvDetailApps);
        tvDetailInch = (TextView) findViewById(R.id.tvDetailInch);

        imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        String code = intent.getExtras().getString("Code");
        String size = intent.getExtras().getString("Size");
        String model = intent.getExtras().getString("Model");
        String price = intent.getExtras().getString("Price");
        String apps = intent.getExtras().getString("Apps");
        String image = intent.getExtras().getString("Pic");
        String inch = intent.getExtras().getString("Inch");


        tvDetailCode.setText(code);
        tvDetailSize.setText(size);
        tvDetailModel.setText(model);
        tvDetailPrice.setText(price);
        tvDetailApps.setText(apps);
        tvDetailInch.setText(inch);
        Glide.with(getApplicationContext()).load(image).into(imageView);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
