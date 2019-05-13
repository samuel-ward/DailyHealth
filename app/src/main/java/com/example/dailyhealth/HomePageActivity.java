package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailyhealth.ui.login.LoginActivity;

public class HomePageActivity extends AppCompatActivity {

        private User user;
        private Boolean registered;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Setting Views
        final View diseaseIntroButton = findViewById(R.id.container_homepage_dieseaseintro);
        final View firstAidButton = findViewById(R.id.container_homepage_firstaid);
        final View measurementButton = findViewById(R.id.container_homepage_measurement);
        final View healthRecordButton = findViewById(R.id.container_homepage_healthrecord);
        final View makeAppointmentButton = findViewById(R.id.container_homepage_appointment);
        final View directSupportButton = findViewById(R.id.container_homepage_service);
        final TextView signinText = findViewById(R.id.lbl_login);

        //Setting Variables
        registered = false;
        try{
                user = (User)getIntent().getSerializableExtra("User");
                if(user.getRegistered()){signinText.setVisibility(View.INVISIBLE);registered=user.getRegistered();}
        } catch (Exception e){

        }

        //Setting Navigation Buttons
        //Login
        signinText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i = new Intent(HomePageActivity.this, LoginActivity.class);
                        startActivity(i);
                }
        });
        //Disease
        diseaseIntroButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i = new Intent(HomePageActivity.this, DiseaseIntro.class);
                        startActivity(i);
                }
        });

        //First-Aid
        firstAidButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i = new Intent(HomePageActivity.this, FirstAid.class);
                        startActivity(i);
                }
        });

        //Measurement
        measurementButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if(registered){
                                Intent i = new Intent(HomePageActivity.this, MeasurementIntro.class);
                                startActivity(i);
                        } else {
                                Toast.makeText(HomePageActivity.this, "Please login",Toast.LENGTH_LONG).show();
                        }
                }
        });

        //Health Record
        healthRecordButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if(registered){
                                Intent i = new Intent(HomePageActivity.this, RecordIntro.class);
                                startActivity(i);
                        } else {
                                Toast.makeText(HomePageActivity.this, "Please login",Toast.LENGTH_LONG).show();
                        }
                }
        });

        //Make Appointment
        makeAppointmentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if(registered){
                                Intent i = new Intent(HomePageActivity.this, AppointmentDate.class);
                                startActivity(i);
                        } else {
                                Toast.makeText(HomePageActivity.this, "Please login",Toast.LENGTH_LONG).show();
                        }
                }
        });

        //Direct Support
        directSupportButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i = new Intent(HomePageActivity.this, SupportIntro.class);
                        startActivity(i);
                }
        });

        }
}
