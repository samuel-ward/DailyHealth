package com.example.dailyhealth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.gson.Gson;

public class RegisterPage4 extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page4);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button finishButton = findViewById(R.id.btn_register_finish);
        final NumberPicker heightPicker = findViewById(R.id.np_register3);

        //Number Picker
        NumberPicker.Formatter format = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value*1;
                return ""+temp;
            }
        };
        int MAX = 240;
        int MIN = 100;
        heightPicker.setFormatter(format);
        heightPicker.setMinValue(MIN);
        heightPicker.setMaxValue(MAX);
        heightPicker.setValue((MAX-MIN)/2);

        //Setting Variables
        user = (User)getIntent().getSerializableExtra("User");

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                finish();
            }
        });

        //Sign Up
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //Finish User
                    user.setHeight(heightPicker.getValue());
                    user.setRegistered(true);

                    //File
                    SharedPreferences mPrefs=getSharedPreferences(getApplicationInfo().name, Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed=mPrefs.edit();
                    Gson gson = new Gson();
                    ed.putString("User", gson.toJson(user));
                    ed.commit();

                    //Intent
                    Intent i = new Intent(RegisterPage4.this, HomePageActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
