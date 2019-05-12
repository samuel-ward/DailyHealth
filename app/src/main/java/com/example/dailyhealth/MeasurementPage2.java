package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MeasurementPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_page2);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_measurement_go_on);

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                finish();
            }
        });

        //Forward Button
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(MeasurementPage2.this, MeasurementPage3.class);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
