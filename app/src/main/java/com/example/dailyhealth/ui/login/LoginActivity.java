package com.example.dailyhealth.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dailyhealth.HomePageActivity;
import com.example.dailyhealth.R;
import com.example.dailyhealth.RegisterIntro;
import com.example.dailyhealth.User;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
    User user;
    EditText usernameEditText;
    EditText passwordEditText;

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        final Button loginButton = findViewById(R.id.btn_login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        final Button skipButton = findViewById(R.id.btn_skip);
        final Button registerButton = findViewById(R.id.btn_register);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Shared Preferences
        SharedPreferences mPrefs=getSharedPreferences(getApplicationInfo().name, Context.MODE_PRIVATE);

        if(mPrefs.contains("User")){

            Gson gson = new Gson();
            String json = mPrefs.getString("User", null);
            user = gson.fromJson(json, User.class);

            if(user.getRegistered()){
                Intent i = new Intent(LoginActivity.this, HomePageActivity.class);
                i.putExtra("User", user);
                startActivity(i);
            }
        }

        //Skip Button
        skipButton.setEnabled(true);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(i);
                } catch(Exception e){
                }
            }
        });

        //Register Button
        registerButton.setEnabled(true);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(LoginActivity.this, RegisterIntro.class);
                    i.putExtra("User",user.getInstance());
                    startActivity(i);
                } catch(Exception e){
                }
            }
        });

        //Login Button
        loginButton.setEnabled(true);
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED)
            finish();

    }

    public void OnLogin(View view){
        String username = usernameEditText.getText().toString();
        //Toast.makeText(this,"User: "+username, Toast.LENGTH_SHORT).show();
        String password = passwordEditText.getText().toString();
        //Toast.makeText(this,"Pass: "+password, Toast.LENGTH_SHORT).show();
        String exType = "get_user";

        BackgroundWorker worker = new BackgroundWorker(this);
        worker.execute(exType, username, password);

        try{
            user = user.getInstance();
            if(user.getRegistered()){
                //File
                SharedPreferences mPrefs=getSharedPreferences(getApplicationInfo().name, Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=mPrefs.edit();
                Gson gson = new Gson();
                ed.putString("User", gson.toJson(user));
                ed.commit();

                //Intent
                Intent i = new Intent(LoginActivity.this, HomePageActivity.class);
                i.putExtra("User", user);
                startActivity(i);
            }
        }catch(Exception e){
            Toast.makeText(LoginActivity.this,"Registration failed: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
