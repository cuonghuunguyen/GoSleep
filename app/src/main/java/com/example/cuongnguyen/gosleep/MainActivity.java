package com.example.cuongnguyen.gosleep;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView ChangeAddSCreen;
    ImageView connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        ChangeAddSCreen = (TextView) findViewById(R.id.textView4);
        connect = (ImageView) findViewById(R.id.imageView2);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarConnector.connectToCalendar(MainActivity.this);
            }
        });

        ChangeAddSCreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddCalendar.class);
                startActivity(i);
            }
        });

    }
}
