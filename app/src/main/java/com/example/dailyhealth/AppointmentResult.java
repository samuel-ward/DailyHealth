package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AppointmentResult extends AppCompatActivity {

    private String location;
    private String date;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_result);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final TextView locationText = findViewById(R.id.lbl_appointment_location);
        final TextView dateText = findViewById(R.id.lbl_appointment_date);
        final TextView timeText = findViewById(R.id.lbl_appointment_time);

        try{
            location = (String)getIntent().getStringExtra("Location");
            locationText.setText(location);
            date = (String)getIntent().getStringExtra("Date");
            dateText.setText(date);
            time = (String)getIntent().getStringExtra("Time");
            timeText.setText(time);
        } catch (Exception e){

        }

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                Intent i = new Intent(AppointmentResult.this, HomePageActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(AppointmentResult.this, HomePageActivity.class);
        startActivity(i);
    }
}
