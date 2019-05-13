package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

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
                    user.setHeight(heightPicker.getValue());
                    Intent i = new Intent(RegisterPage4.this, HomePageActivity.class);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
