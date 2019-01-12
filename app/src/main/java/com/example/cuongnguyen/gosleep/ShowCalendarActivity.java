package com.example.cuongnguyen.gosleep;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ShowCalendarActivity extends AppCompatActivity implements CalendarAdapter.OnEditClickListener{
    ListView lvCalendar;
    ArrayList<MyCalendar> arrCalender;
    ImageView logo;
    int pos;

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


        arrCalender.add(new MyCalendar(1, "di ngu", "day som nhaa",timeEndformat,timeEndformat,timeEndformat));
        arrCalender.add(new MyCalendar(2, "aaaaaaaaaaaa", "day som nhaa",timeEndformat,timeEndformat,timeEndformat));

        CalendarAdapter adapter =new CalendarAdapter(
                ShowCalendarActivity.this,
                R.layout.detail_time,
                arrCalender, this

        );
        lvCalendar.setAdapter(adapter);
    }


    @Override
    public void onEditClick(final int pos) {
        Log.i("linh","edite");
        Intent i = new Intent(ShowCalendarActivity.this, EditCalendarActivity.class);
        startActivity(i);
        Log.d("ADebugTag", "Value: " + Integer.toString(pos));
      


    }

    @Override
    public void onDeleteClick(final int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }
}