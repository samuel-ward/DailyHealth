package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterIntro extends AppCompatActivity {

    private String username;
    private String email;
    private String password;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_intro);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button signupButton = findViewById(R.id.btn_register_signup);
        final EditText usernameInput = findViewById(R.id.et_register_username);
        final EditText emailInput = findViewById(R.id.et_register_email);
        final EditText passwordInput = findViewById(R.id.et_register_password);

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
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    Intent i = new Intent(RegisterIntro.this, RegisterPage1.class);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
