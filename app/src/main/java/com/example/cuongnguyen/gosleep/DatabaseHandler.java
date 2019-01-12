package com.example.cuongnguyen.gosleep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                KEY_ID +" integer primary key, "+
                KEY_TITLE + " TEXT, "+
                KEY_CONTENT +" TEXT, "+
                KEY_DAY+" TEXT," +
                KEY_TIMESTART+" TEXT," +
                KEY_TIMEEND +" TEXT)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_calendar_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_calendar_table);

        onCreate(db);
    }


    //Add new a calendar
    public void addCalendar(MyCalendar calendar){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, calendar.getTitle());
        values.put(KEY_CONTENT, calendar.getContent());
        values.put(KEY_DAY, calendar.getDayformat());
        values.put(KEY_TIMESTART, calendar.getTimeStartformat());
        values.put(KEY_TIMEEND, calendar.getTimeEndformat());
        //Neu de null thi khi value bang null thi loi

        db.insert(TABLE_NAME,null,values);

        db.close();
    }

    // select List calender

    public List<MyCalendar> getAllcalendar() {
        List<MyCalendar>  studentList = new ArrayList<>();
        String selectQuery = "SELECT " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do {
             MyCalendar student = new MyCalendar();
             student.setId(cursor.getInt(0));
             student.setTitle(cursor.getString(1));
             student.setContent(cursor.getString(2));
             student.setDayformat(cursor.getString(3));
             student.setTimeStartformat(cursor.getString(4));
             student.setTimeEndformat(cursor.getString(5));
             studentList.add(student);
            }while (cursor.moveToNext());
        }db.close();
        return studentList;
    }
}