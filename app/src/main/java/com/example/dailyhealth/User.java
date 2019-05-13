package com.example.dailyhealth;

import java.io.Serializable;

public class User implements Serializable {
    //Private
    private String username;
    private String email;
    private String password;
    private Boolean sex;
    private int age;
    private int weight;
    private int height;
    private static User user = null;

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
    }

    //Public
    public static User getInstance(){
        if(user == null)
            user = new User();
        return user;
    }

    // Set/Get
    void setUsername(String reading){username=reading;}
    void setEmail(String reading){email=reading;}
    void setPassword(String reading){password=reading;}
    void setSex(Boolean reading){sex=reading;}
    void setAge(int reading){age=reading;}
    void setWeight(int reading){weight=reading;}
    void setHeight(int reading){height=reading;}
    String getUsername(){return username;}
    String getEmail(){return email;}
    String getPassword(){return password;}
    Boolean getSex(){return sex;}
    int getAge(){return age;}
    int getWeight(){return weight;}
    int getHeight(){return height;}
}
