package com.example.dailyhealth;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MeasurementPage5 extends AppCompatActivity {

    int respiratoryEffort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_page5);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button forwardButton = findViewById(R.id.btn_measurement_go_on);
        final ImageView option1 = findViewById(R.id.btn_opt1);
        final ImageView option2 = findViewById(R.id.btn_opt2);
        final ImageView option3 = findViewById(R.id.btn_opt3);
        final ImageView option4 = findViewById(R.id.btn_opt4);

        //Option Select
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respiratoryEffort = 0;
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respiratoryEffort = 1;
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respiratoryEffort = 2;
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respiratoryEffort = 3;
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
            }
        });

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
                    //Toast.makeText(MeasurementPage5.this, "You have chosen " + respiratoryEffort, Toast.LENGTH_LONG).show();
                    measurement = (AsthmaMeasurement) getIntent().getSerializableExtra("Measurement");
                    measurement.setSentenceFormation(respiratoryEffort);

                    Intent i = new Intent(MeasurementPage5.this, MeasurementPage6.class);
                    i.putExtra("Measurement", measurement);
                    startActivityForResult(i,1);

                }catch(Exception e){
                    //Toast.makeText(MeasurementPage5.this, "Please choose an option", Toast.LENGTH_LONG).show();
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
