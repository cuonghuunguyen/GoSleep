package com.example.cuongnguyen.gosleep;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class CalendarConnector {
    private static Cursor cursor;
    public static void connectToCalendar(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage("Permission is not granted")
                    .setTitle("Error")
                    .setPositiveButton(android.R.string.ok, null);
            AlertDialog dialog = builder.create();
            dialog.show();
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.READ_CALENDAR},
                    1);

        }
        String selection = "(dtstart >=?)";
        String[] projection = new String[] {
                CalendarContract.Events._ID,
                CalendarContract.Events.TITLE,
                CalendarContract.Events.DESCRIPTION,
                CalendarContract.Events.DTSTART,
                CalendarContract.Events.DTEND
        };
        String[] args = new String[] {
                String.valueOf(System.currentTimeMillis())
        };
        cursor = activity.getContentResolver().query(CalendarContract.Events.CONTENT_URI,projection,selection,args,null);

        DatabaseHandler dh = new DatabaseHandler(activity);

        while (cursor.moveToNext()) {
            dh.addCalendar(new MyCalendar(cursor.getString(1),cursor.getString(2),cursor.getLong(3),cursor.getLong(4)));
        }

    }
}
