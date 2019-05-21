package com.example.dailyhealth;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    //Private
    private String username;
    private String email;
    private String password;
    private Boolean sex;
    private int age;
    private int weight;
    private int height;
    private static User instance;
    private Boolean registered;
    private ArrayList<Record> recordList;

    //Singleton
    private User(){
        //Constructor
        username = "";
        email = "";
        password = "";
        sex = null;
        age = 0;
        weight = 0;
        height = 0;
        registered = false;
        recordList = null;
    }

    //Public
    public static User getInstance(){
        if(instance == null)
            instance = new User();
        return instance;
    }

    // Set/Get
    public void setUsername(String reading){username=reading;}
    public void setEmail(String reading){email=reading;}
    public void setPassword(String reading){password=reading;}
    public void setSex(Boolean reading){sex=reading;}
    public void setAge(int reading){age=reading;}
    public void setWeight(int reading){weight=reading;}
    public void setHeight(int reading){height=reading;}
    public void setRegistered(Boolean reading){registered=reading;}
    public void setRecordList(ArrayList<Record> reading){recordList=reading;}
    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public Boolean getSex(){return sex;}
    public int getAge(){return age;}
    public int getWeight(){return weight;}
    public int getHeight(){return height;}
    public Boolean getRegistered(){return registered;}
    public ArrayList<Record> getRecordList(){return recordList;}
}
