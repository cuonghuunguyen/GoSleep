package com.example.cuongnguyen.gosleep;

import java.util.Date;

public class Calendar {
    int id;
    String Title;
    String Content;
    Date day;
    Date timeStart;
    Date timeEnd;

    public Calendar(int id, String title, String content, Date day, Date timeStart, Date timeEnd) {
        this.id = id;
        Title = title;
        Content = content;
        this.day = day;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
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
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
}
