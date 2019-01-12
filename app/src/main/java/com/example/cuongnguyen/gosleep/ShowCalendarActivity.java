package com.example.cuongnguyen.gosleep;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowCalendarActivity extends AppCompatActivity {
    ListView lvCalendar;
    ArrayList<MyCalendar> arrCalender;
    ImageView logo;
    Button btnlistcongviec;
    private CustomAdapter customAdapter;
    private List<MyCalendar> students;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_time);
        logo = (ImageView)findViewById(R.id.imageView4);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowCalendarActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        lvCalendar =(ListView) findViewById(R.id.listView);
        arrCalender = new ArrayList<MyCalendar>();

        Format formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date time =new Date();
        String timeEndformat = formatter.format(time);


        arrCalender.add(new MyCalendar(1, "di ngu", "day som nhaa 123",timeEndformat,timeEndformat,timeEndformat));
        arrCalender.add(new MyCalendar(2, "aaaaaaaaaaaa", "day som nhaa",timeEndformat,timeEndformat,timeEndformat));

        CalendarAdapter adapter =new CalendarAdapter(
                ShowCalendarActivity.this,
                R.layout.detail_time,
                arrCalender
        );
        lvCalendar.setAdapter(adapter);
        //

    }
}

