package com.example.cuongnguyen.gosleep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import pl.droidsonroids.gif.GifDrawable;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;
    private ProgressBar pgsBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pgsBar = (ProgressBar) findViewById(R.id.pBar);

        pgsBar.setVisibility(View.GONE);
        pgsBar.setVisibility(View.VISIBLE );

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){


                Intent splashintent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splashintent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
