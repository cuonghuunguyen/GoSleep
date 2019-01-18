package com.example.cuongnguyen.gosleep;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyCalendar {
    int id;
    String Title;
    String Content;

    Date day = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    String dayformat = formatter.format(day);

    Date timeStart = new Date();
    SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
    String timeStartformat = formatter1.format(day);

    Date timeEnd = new Date();
    String timeEndformat = formatter1.format(day);

    public MyCalendar(){

    }

    public MyCalendar(String title, String content, String dayformat, String timeStartformat, String timeEndformat) {
        this.Title = title;
        this.Content = content;
        this.dayformat = dayformat;
        this.timeStartformat = timeStartformat;
        this.timeEndformat = timeEndformat;
    }

    public MyCalendar(String title, String content, long timeStart, long timeEnd ) {
        this.Title = title;
        this.Content = content;
        this.dayformat = formatter.format(new Date(timeStart));
        this.timeStartformat = formatter1.format(new Date(timeStart));
        this.timeEndformat = formatter1.format(new Date(timeEnd));
    }

    public MyCalendar(int id, String title, String content, String dayformat, String timeStartformat, String timeEndformat) {
        this.id = id;
        this.Title = title;
        this.Content = content;
        this.dayformat = dayformat;
        this.timeStartformat = timeStartformat;
        this.timeEndformat = timeEndformat;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String getDayformat() {
        return dayformat;
    }

    public void setDayformat(String dayformat) {
        this.dayformat = dayformat;
    }

    public String getTimeStartformat() {
        return timeStartformat;
    }

    public void setTimeStartformat(String timeStartformat) {
        this.timeStartformat = timeStartformat;
    }

    public String getTimeEndformat() {
        return timeEndformat;
    }

    public void setTimeEndformat(String timeEndformat) {
        this.timeEndformat = timeEndformat;
    }


    @Override
    public String toString() {
        return "MyCalendar{" +
                "Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                ", dayformat='" + dayformat + '\'' +
                ", timeStartformat='" + timeStartformat + '\'' +
                ", timeEndformat='" + timeEndformat + '\'' +
                '}';
    }
}
