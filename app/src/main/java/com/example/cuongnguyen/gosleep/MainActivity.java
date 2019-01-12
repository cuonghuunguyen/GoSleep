package com.example.cuongnguyen.gosleep;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView ChangeAddSCreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        ChangeAddSCreen = (TextView) findViewById(R.id.textView4);
        ChangeAddSCreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddCalendar.class);
                startActivity(i);
            }
        });
    }
}
