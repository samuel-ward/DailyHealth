package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import java.lang.reflect.Method;

public class RegisterPage3 extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page3);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_register_go_on);
        final NumberPicker weightPicker = findViewById(R.id.np_register2);

        //Number Picker
        NumberPicker.Formatter format = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value*1;
                return ""+temp+" kg";
            }
        };
        int MAX = 300;
        int MIN = 20;
        weightPicker.setFormatter(format);
        weightPicker.setMinValue(MIN);
        weightPicker.setMaxValue(MAX);
        weightPicker.setValue((MAX-MIN)/4);
        try{
            //Fix First Element Issue
            Method method = weightPicker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
            method.setAccessible(true);
            method.invoke(weightPicker, true);
        } catch (Exception e){

        }

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
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    user.setWeight(weightPicker.getValue());
                    Intent i = new Intent(RegisterPage3.this, RegisterPage4.class);
                    i.putExtra("User",user);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
