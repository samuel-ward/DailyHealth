package com.example.dailyhealth;

import java.io.Serializable;

public class Record implements Serializable {

    //Private
    private String date;
    private String title;
    private String details;

    //Constructor
    Record(String da, String ti, String de){
        date = da;
        title = ti;
        details = de;
    }

    //Retrieve
    String getDate(){return "Date:\n"+date;}
    String getTitle(){return "Title: "+title;}
    String getDetails(){return details;}

}
