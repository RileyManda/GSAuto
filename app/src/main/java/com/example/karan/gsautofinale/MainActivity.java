package com.example.karan.gsautofinale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.karan.gsautofinale.Cars.CarActivity;
import com.example.karan.gsautofinale.LoginActivity.LoginActivity;
import com.example.karan.gsautofinale.MainScreen.MainAdapter;
import com.example.karan.gsautofinale.MainScreen.Model;
import com.example.karan.gsautofinale.Products.Studs.StudsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth fAuth;
    RecyclerView recyclerView;
    ImageView ivPic;
    TextView tvPicName;
    TextView tv_user;
    MainAdapter mainAdapter;
    private List<Model> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fAuth = FirebaseAuth.getInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        model = new ArrayList<>();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        mainAdapter = new MainAdapter(model,this.getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        tvPicName = (TextView) findViewById(R.id.tvPicName);
        ivPic = (ImageView) findViewById(R.id.ivPic);

        recyclerView.setAdapter(mainAdapter);
        runAnimation(recyclerView,0);
        PrepareAlbums();

        com.github.clans.fab.FloatingActionButton fab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.homee:
                    Intent intent = new Intent(MainActivity.this, StudsActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.car:
                    Intent intentt = new Intent(MainActivity.this, CarActivity.class);
                    startActivity(intentt);
                    return true;
                case R.id.products:
                    Intent intenttt = new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intenttt);
                    return true;
                case R.id.aboutus:
                    Intent intent1 = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent1);
                    return true;
            }

            return false;
        }
    };

    public void runAnimation(RecyclerView recyclerView,int type){
        Context context = recyclerView.getContext();
        LayoutAnimationController controller = null;
        if (type == 0){
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);

            MainAdapter adapter = new MainAdapter(model,context);
            recyclerView.setAdapter(adapter);

            recyclerView.setLayoutAnimation(controller);
            recyclerView.getAdapter().notifyDataSetChanged();
            recyclerView.scheduleLayoutAnimation();
        }
    }

    public void PrepareAlbums(){

        int[] covers = new int[]{
                R.drawable.checkk,
                R.drawable.studs,
                R.drawable.kingpin,
                R.drawable.springpins,
                R.drawable.bushes,
                R.drawable.centerbolts,
                R.drawable.ubolts,
                R.drawable.castings,
                R.drawable.rings,
                R.drawable.nut,
                R.drawable.hub,
                R.drawable.hubbolt,
                R.drawable.trailer,
                R.drawable.washer};

        Model m = new Model(covers[0],"CheckNuts");
        model.add(m);
        m = new Model(covers[1],"Studs");
        model.add(m);
        m = new Model(covers[2],"KingPins");
        model.add(m);
        m = new Model(covers[3],"Spring pin bolt");
        model.add(m);
        m = new Model(covers[4],"Misc. Bolts");
        model.add(m);
        m = new Model(covers[5],"Spring center bolt with nut");
        model.add(m);
        m = new Model(covers[6],"Spring UBolts");
        model.add(m);
        m = new Model(covers[7],"Casting");
        model.add(m);
        m = new Model(covers[8],"Rings");
        model.add(m);
        m = new Model(covers[9],"Nuts");
        model.add(m);
        m = new Model(covers[10],"Hub Bolts");
        model.add(m);
        m = new Model(covers[11],"Spring Shackle bolts");
        model.add(m);
        m = new Model(covers[12],"Trailer Parts");
        model.add(m);
        m = new Model(covers[13],"Hub Bolt Washers");
        model.add(m);

        mainAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = fAuth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.gallery) {

        } else if (id == R.id.sign_out) {
            fAuth.signOut();

            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }else if (id == R.id.contact) {

            Intent intent = new Intent(MainActivity.this,ContactActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
