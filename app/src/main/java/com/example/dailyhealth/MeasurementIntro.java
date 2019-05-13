package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeasurementIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_intro);

        //Setting Views
        final Button doItNowButton = findViewById(R.id.btn_measurement_yes);
        final Button doItLaterButton = findViewById(R.id.btn_measurement_no);

        //Setting Navigation
        //Do It Now Button
        doItNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MeasurementIntro.this, MeasurementPage1.class);
                startActivityForResult(i,1);
            }
        });

        //Do It Later Button
        doItLaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==2){
            finish();
        }
    }
}
