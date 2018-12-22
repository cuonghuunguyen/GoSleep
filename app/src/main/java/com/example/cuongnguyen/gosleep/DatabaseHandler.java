package com.example.cuongnguyen.gosleep;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "calendarManagement";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "calendar";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DAY = "day";
    private static final String KEY_TIMESTART = "timeStart";
    private static final String KEY_TIMEEND = "timeEnd";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_calendar_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_TITLE, KEY_CONTENT, KEY_DAY,KEY_TIMESTART,KEY_TIMEEND);
        db.execSQL(create_calendar_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_calendar_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_calendar_table);

        onCreate(db);
    }
}