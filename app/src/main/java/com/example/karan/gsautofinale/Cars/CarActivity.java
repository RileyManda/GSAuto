package com.example.karan.gsautofinale.Cars;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.karan.gsautofinale.R;

public class CarActivity extends AppCompatActivity{

    TextView ambassador,jeep,ace;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        ambassador = (TextView) findViewById(R.id.ambassador);
        jeep = (TextView) findViewById(R.id.jeep);
        ace = (TextView) findViewById(R.id.ace);

       ambassador.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
               fragmentTransaction.replace(R.id.frameLayout,new AmbassadorFragment());
               fragmentTransaction.commit();
           }
       });

       jeep.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentTransaction fragmentTransactionn = getSupportFragmentManager().beginTransaction();
               fragmentTransactionn.replace(R.id.frameLayout,new JeepFragment());
               fragmentTransactionn.commit();
           }
       });

       ace.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               FragmentTransaction fragmentTransactioon = getSupportFragmentManager().beginTransaction();
               fragmentTransactioon.replace(R.id.frameLayout,new AceFragment());
               fragmentTransactioon.commit();
           }
       });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
