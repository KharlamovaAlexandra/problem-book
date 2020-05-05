package com.example.anlaba5;

import android.graphics.Color;

import java.io.Serializable;
import java.util.Calendar;

public class Task implements Serializable {
    public String title;
    public String desc;
    public Calendar dateAndTime = Calendar.getInstance();
    public int prioritet;



    public Task(String title, String desc, Calendar dateAndTime, int prior) {
        this.title = title;
        this.desc = desc;
        this.dateAndTime = dateAndTime;
        this.prioritet = prior;


    }
    public String getTitle(){return title;}
    public String getDesc(){return title;}
    public Calendar getDateAndTime() {
        return dateAndTime;
    }
    public int getPrior(){return prioritet;}



}