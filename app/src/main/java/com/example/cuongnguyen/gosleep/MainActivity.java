package com.example.cuongnguyen.gosleep;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lvCalendar;
    ArrayList<Calendar> arrCalender;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_time);

        lvCalendar =(ListView) findViewById(R.id.listView);
        arrCalender = new ArrayList<Calendar>();
        Format formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date time =new Date();
        arrCalender.add(new Calendar(1, "di ngu", "day som nhaa",time,time,time));
        arrCalender.add(new Calendar(2, "aaaaaaaaaaaa", "day som nhaa",time,time,time));
        arrCalender.add(new Calendar(3, "ddgdgfd", "day som nhaa",time,time,time));
        arrCalender.add(new Calendar(4, "fgfgf", "day som nhaa",time,time,time));
        arrCalender.add(new Calendar(5, "tytytyt", "day som nhaa",time,time,time));
        CalendarAdapter adapter =new CalendarAdapter(
          MainActivity.this,
          R.layout.detail_time,
          arrCalender
        );
        lvCalendar.setAdapter(adapter);
    }
}