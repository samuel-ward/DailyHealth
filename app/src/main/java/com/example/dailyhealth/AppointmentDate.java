package com.example.dailyhealth;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppointmentDate extends AppCompatActivity {

    //private int timeOption;
    private String time;
    private SimpleDateFormat dateFormat;
    private String date;
    private int locationIndex;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_date);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final ImageView option1 = findViewById(R.id.btn_opt1);
        final ImageView option2 = findViewById(R.id.btn_opt2);
        final ImageView option3 = findViewById(R.id.btn_opt3);
        final ImageView option4 = findViewById(R.id.btn_opt4);
        final ImageView option5 = findViewById(R.id.btn_opt5);
        final ImageView option6 = findViewById(R.id.btn_opt6);
        final TextView option1Text = findViewById(R.id.lbl_appointment_date_opt1);
        final TextView option2Text = findViewById(R.id.lbl_appointment_date_opt2);
        final TextView option3Text = findViewById(R.id.lbl_appointment_date_opt3);
        final TextView option4Text = findViewById(R.id.lbl_appointment_date_opt4);
        final TextView option5Text = findViewById(R.id.lbl_appointment_date_opt5);
        final TextView option6Text = findViewById(R.id.lbl_appointment_date_opt6);
        final Spinner spinnerLocations = findViewById(R.id.spinner_location2);
        final CalendarView calendarView = findViewById(R.id.calendarView);
        final Button forwardButton = findViewById(R.id.btn_measurement_go_on);

        //CalendarView
        dateFormat = new SimpleDateFormat("dd-MM-yyy", Locale.getDefault());
        calendarView.setDate(System.currentTimeMillis(),false,true);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dateFormat.format(new Date(calendarView.getDate()));
            }
        });

        //Location Spinner
        final ArrayAdapter<CharSequence> styleAdapter = ArrayAdapter.createFromResource(this, R.array.locations, R.layout.support_simple_spinner_dropdown_item);
        styleAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerLocations.setAdapter(styleAdapter);
        spinnerLocations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                locationIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Option Select
        //timeOption = 0;
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timeOption = 1;
                time = (String)option1Text.getText();
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timeOption = 2;
                time = (String)option2Text.getText();
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timeOption = 3;
                time = (String)option3Text.getText();
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timeOption = 4;
                time = (String)option4Text.getText();
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timeOption = 5;
                time = (String)option5Text.getText();
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
                option6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
            }
        });
        option6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timeOption = 6;
                time = (String)option6Text.getText();
                option1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLBlue)));
                option6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDBlue)));
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

                    location = styleAdapter.getItem(locationIndex).toString();
                    Intent i = new Intent(AppointmentDate.this, AppointmentResult.class);
                    i.putExtra("Date", date);
                    i.putExtra("Location",location);
                    i.putExtra("Time",time);
                    startActivityForResult(i,1);

                }catch(Exception e){
                    Toast.makeText(AppointmentDate.this, "Please select a time, date, and location", Toast.LENGTH_LONG).show();
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
}
