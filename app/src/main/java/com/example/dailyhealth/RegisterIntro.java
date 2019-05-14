package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
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
    private Boolean[] progress;

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

        //Set Variables
        user = user.getInstance();
        progress = new Boolean[3];
        for(int i = 0; i < progress.length; i++){
            progress[i] = false;
        }

        //Text Change Events
        //Username Field
        usernameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                username = usernameInput.getText().toString();
                progress[0] = true;
                //Toast.makeText(RegisterIntro.this, "Username: "+ username, Toast.LENGTH_SHORT).show();
            }
        });
        //Email Field
        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isValidEmail(emailInput.getText())){
                    email = emailInput.getText().toString();
                    progress[1] = true;
                    //Toast.makeText(RegisterIntro.this, "Email: "+ email, Toast.LENGTH_SHORT).show();
                } else {
                }
            }
        });
        //Password Field
        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                password = passwordInput.getText().toString();
                progress[2] = true;
                //Toast.makeText(RegisterIntro.this, "Password: "+ password, Toast.LENGTH_SHORT).show();
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
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isValidEmail(email)){
                    try{

                        if(progress[0] && progress[1] && progress[2]){
                            user.setUsername(username);
                            user.setEmail(email);
                            user.setPassword(password);
                            Intent i = new Intent(RegisterIntro.this, RegisterPage1.class);
                            i.putExtra("User",user);
                            startActivity(i);
                        }
                    }catch(Exception e){
                        //Toast.makeText(RegisterIntro.this, "Something went wrong: " +e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(RegisterIntro.this, "Please provide a valid email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
