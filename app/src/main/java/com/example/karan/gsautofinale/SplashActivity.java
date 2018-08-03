package com.example.karan.gsautofinale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView ivLogo;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        title = (TextView) findViewById(R.id.title);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        title.setAnimation(animation);
        ivLogo.setAnimation(animation);

        final Intent intent = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {

                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

    }
}
