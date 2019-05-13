package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

public class RegisterPage2 extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page2);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_register_go_on);
        final NumberPicker agePicker = findViewById(R.id.np_register1);

        //Number Picker
        NumberPicker.Formatter format = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value*1;
                return ""+temp;
            }
        };
        int MAX = 120;
        int MIN = 0;
        agePicker.setFormatter(format);
        agePicker.setMinValue(MIN);
        agePicker.setMaxValue(MAX);
        agePicker.setValue((MAX-MIN)/4);

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
                    user.setAge(agePicker.getValue());
                    Intent i = new Intent(RegisterPage2.this, RegisterPage3.class);
                    i.putExtra("User",user);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
