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

public class MeasurementPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_page1);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_measurement_go_on);
        final NumberPicker measuredFlowPicker = findViewById(R.id.np_measurement1);

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
        measuredFlowPicker.setFormatter(format);
        measuredFlowPicker.setMinValue(MIN);
        measuredFlowPicker.setMaxValue(MAX);
        measuredFlowPicker.setValue((MAX-MIN)/2);
        try{
            //Fix First Element Issue
            Method method = measuredFlowPicker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
            method.setAccessible(true);
            method.invoke(measuredFlowPicker, true);
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

                    int chosenValue = measuredFlowPicker.getValue()*10;
                    //Toast.makeText(MeasurementPage1.this, "You have chosen " + chosenValue, Toast.LENGTH_LONG).show();
                    AsthmaMeasurement measurement = new AsthmaMeasurement();
                    measurement.setMeasuredPeakFlow(chosenValue);

                    Intent i = new Intent(MeasurementPage1.this, MeasurementPage2.class);
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
