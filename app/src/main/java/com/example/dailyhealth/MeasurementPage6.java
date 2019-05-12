package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MeasurementPage6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_page6);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_measurement_go_on);
        final NumberPicker heartRatePicker = findViewById(R.id.np_measurement6);

        //Number Picker
        NumberPicker.Formatter format = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                //For consistency sake
                int temp = value;
                return ""+temp;
            }
        };
        int MAX = 150;
        int MIN = 30;
        heartRatePicker.setFormatter(format);
        heartRatePicker.setMinValue(MIN);
        heartRatePicker.setMaxValue(MAX);
        heartRatePicker.setValue((MAX-MIN)/2);

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

                    AsthmaMeasurement measurement;
                    int chosenValue = heartRatePicker.getValue();
                    Toast.makeText(MeasurementPage6.this, "You have chosen " + chosenValue, Toast.LENGTH_LONG).show();
                    measurement = (AsthmaMeasurement) getIntent().getSerializableExtra("Measurement");
                    measurement.setRespiratoryRate(chosenValue);

                    Intent i = new Intent(MeasurementPage6.this, MeasurementPage7.class);
                    i.putExtra("Measurement", measurement);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
