package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

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

        //Setting Navigation Buttons
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
                        Intent i = new Intent(HomePageActivity.this, MeasurementIntro.class);
                        startActivity(i);
                }
        });

        //Health Record
        healthRecordButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i = new Intent(HomePageActivity.this, RecordIntro.class);
                        startActivity(i);
                }
        });

        //Make Appointment
        makeAppointmentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i = new Intent(HomePageActivity.this, AppointmentLocation.class);
                        startActivity(i);
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
