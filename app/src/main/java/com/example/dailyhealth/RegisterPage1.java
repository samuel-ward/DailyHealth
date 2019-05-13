package com.example.dailyhealth;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterPage1 extends AppCompatActivity {

    private User user;
    private boolean sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page1);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_register_go_on);
        final ImageView maleButton = findViewById(R.id.img_male);
        final ImageView femaleButton = findViewById(R.id.img_female);

        //Setting Variables
        user = (User)getIntent().getSerializableExtra("User");

        //Buttons
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = true;
                maleButton.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                femaleButton.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = false;
                maleButton.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                femaleButton.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
            }
        });

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
                    user.setSex(sex);
                    Intent i = new Intent(RegisterPage1.this, RegisterPage2.class);
                    i.putExtra("User",user);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
