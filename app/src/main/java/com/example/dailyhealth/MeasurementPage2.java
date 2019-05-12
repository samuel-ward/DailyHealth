package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MeasurementPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_page2);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_measurement_go_on);
        final NumberPicker predictedFlowPicker = findViewById(R.id.np_measurement2);

        //Number Picker
        int PICKER_RANGE = 10;
        int NUMBER_OF_VALUES = 70;
        final String [] displayValues = new String[NUMBER_OF_VALUES];
        for(int i = 0; i < NUMBER_OF_VALUES; i++){
            displayValues[i] = String.valueOf(PICKER_RANGE * (i+1) * 100);
        }
        predictedFlowPicker.setMinValue(0);
        predictedFlowPicker.setMaxValue(displayValues.length -1);
        predictedFlowPicker.setValue(displayValues.length/2);

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
                    int chosenValue = predictedFlowPicker.getValue();
                    Toast.makeText(MeasurementPage2.this, "You have chosen " + chosenValue, Toast.LENGTH_LONG).show();
                    measurement = (AsthmaMeasurement) getIntent().getSerializableExtra("Measurement");
                    measurement.setPredictedPeakFlow(chosenValue);

                    Intent i = new Intent(MeasurementPage2.this, MeasurementPage3.class);
                    i.putExtra("Measurement", measurement);
                    startActivity(i);
                }catch(Exception e){

                }
            }
        });
    }
}
