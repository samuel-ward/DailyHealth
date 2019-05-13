package com.example.dailyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MeasurementResult extends AppCompatActivity {
    AsthmaMeasurement measurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_result);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button mildButton = findViewById(R.id.btn_severity1);
        final Button moderateButton = findViewById(R.id.btn_severity2);
        final Button severeButton = findViewById(R.id.btn_severity3);
        final Button emergencyButton = findViewById(R.id.btn_severity4);
        final TextView actionPlan = findViewById(R.id.tv_severity);

        //Setting Buttons
        mildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mildButton.setBackgroundColor(getResources().getColor(R.color.colorDMild));
                moderateButton.setBackgroundColor(getResources().getColor(R.color.colorModerate));
                severeButton.setBackgroundColor(getResources().getColor(R.color.colorSevere));
                emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorEmergency));
                actionPlan.setText(R.string.severity_mild);
            }
        });
        moderateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mildButton.setBackgroundColor(getResources().getColor(R.color.colorMild));
                moderateButton.setBackgroundColor(getResources().getColor(R.color.colorDModerate));
                severeButton.setBackgroundColor(getResources().getColor(R.color.colorSevere));
                emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorEmergency));
                actionPlan.setText(R.string.severity_moderate);
            }
        });
        severeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mildButton.setBackgroundColor(getResources().getColor(R.color.colorMild));
                moderateButton.setBackgroundColor(getResources().getColor(R.color.colorModerate));
                severeButton.setBackgroundColor(getResources().getColor(R.color.colorDSevere));
                emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorEmergency));
                actionPlan.setText(R.string.severity_severe);
            }
        });
        emergencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mildButton.setBackgroundColor(getResources().getColor(R.color.colorMild));
                moderateButton.setBackgroundColor(getResources().getColor(R.color.colorModerate));
                severeButton.setBackgroundColor(getResources().getColor(R.color.colorSevere));
                emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorDEmergency));
                actionPlan.setText(R.string.severity_emergency);
            }
        });

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                try{
                    setResult(2);
                    finish();
                }catch(Exception e){

                }
            }
        });

        //Calculations
        try{
            measurement = (AsthmaMeasurement)getIntent().getSerializableExtra("Measurement");
            int calculation = measurement.calculateSeverity(measurement.calculateSeverityTotal());

            switch (calculation){
                case 0:
                    //Mild
                    Toast.makeText(MeasurementResult.this, "You have mild symptoms",Toast.LENGTH_LONG).show();
                    mildButton.setBackgroundColor(getResources().getColor(R.color.colorDMild));
                    moderateButton.setBackgroundColor(getResources().getColor(R.color.colorModerate));
                    severeButton.setBackgroundColor(getResources().getColor(R.color.colorSevere));
                    emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorEmergency));
                    actionPlan.setText(R.string.severity_mild);
                    break;
                case 1:
                    //Moderate
                    Toast.makeText(MeasurementResult.this, "You have moderate symptoms",Toast.LENGTH_LONG).show();
                    mildButton.setBackgroundColor(getResources().getColor(R.color.colorMild));
                    moderateButton.setBackgroundColor(getResources().getColor(R.color.colorDModerate));
                    severeButton.setBackgroundColor(getResources().getColor(R.color.colorSevere));
                    emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorEmergency));
                    actionPlan.setText(R.string.severity_moderate);
                    break;
                case 2:
                    //Severe
                    Toast.makeText(MeasurementResult.this, "You have severe symptoms",Toast.LENGTH_LONG).show();
                    mildButton.setBackgroundColor(getResources().getColor(R.color.colorMild));
                    moderateButton.setBackgroundColor(getResources().getColor(R.color.colorModerate));
                    severeButton.setBackgroundColor(getResources().getColor(R.color.colorDSevere));
                    emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorEmergency));
                    actionPlan.setText(R.string.severity_severe);
                    break;
                case 3:
                    //Emergency
                    Toast.makeText(MeasurementResult.this, "This is an emergency, call 111 as soon as possible",Toast.LENGTH_LONG).show();
                    mildButton.setBackgroundColor(getResources().getColor(R.color.colorMild));
                    moderateButton.setBackgroundColor(getResources().getColor(R.color.colorModerate));
                    severeButton.setBackgroundColor(getResources().getColor(R.color.colorSevere));
                    emergencyButton.setBackgroundColor(getResources().getColor(R.color.colorDEmergency));
                    actionPlan.setText(R.string.severity_emergency);
                    break;

            }
        } catch (Exception e){
            Toast.makeText(MeasurementResult.this, "Something went wrong, please take your measurement again", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        setResult(2);
        finish();
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
