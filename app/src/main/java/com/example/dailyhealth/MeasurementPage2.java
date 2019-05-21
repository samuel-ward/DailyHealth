package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.lang.reflect.Method;

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
        NumberPicker.Formatter format = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value*10;
                return ""+temp;
            }
        };
        int MAX = 70;
        int MIN = 0;
        predictedFlowPicker.setFormatter(format);
        predictedFlowPicker.setMinValue(MIN);
        predictedFlowPicker.setMaxValue(MAX);
        predictedFlowPicker.setValue((MAX-MIN)/2);
        try{
            //Fix First Element Issue
            Method method = predictedFlowPicker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
            method.setAccessible(true);
            method.invoke(predictedFlowPicker, true);
        } catch (Exception e){

        }

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
                    int chosenValue = predictedFlowPicker.getValue()*10;
                    //Toast.makeText(MeasurementPage2.this, "You have chosen " + chosenValue, Toast.LENGTH_LONG).show();
                    measurement = (AsthmaMeasurement) getIntent().getSerializableExtra("Measurement");
                    measurement.setPredictedPeakFlow(chosenValue);

                    Intent i = new Intent(MeasurementPage2.this, MeasurementPage3.class);
                    i.putExtra("Measurement", measurement);
                    startActivityForResult(i,1);
                }catch(Exception e){

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==2){
            finish();
        }
    }

    @Override
    protected void onStop() {
        setResult(2);
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        setResult(2);
        super.onDestroy();
    }
}
