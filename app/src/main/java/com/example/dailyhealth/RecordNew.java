package com.example.dailyhealth;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecordNew extends AppCompatActivity {

    private SimpleDateFormat dateFormat;
    private String date;
    private String title;
    private String details;
    private Record record;
    private ArrayList<Record> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_new);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final EditText recordTitle = findViewById(R.id.et_record_title);
        final EditText recordDetails = findViewById(R.id.et_record_detail);
        final Button addNewRecordButton = findViewById(R.id.btn_save_record);

        //Variables
        dateFormat = new SimpleDateFormat("dd-MM-yyy|HH:mm", Locale.getDefault());

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                finish();
            }
        });

        //Add Button
        addNewRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    date = "Date:\n"+dateFormat.format(new Date());
                    title = "Title:"+recordTitle.getText().toString();
                    details = recordDetails.getText().toString();
                    record = new Record(date, title, details);

                    //File
                    SharedPreferences mPrefs=getSharedPreferences(getApplicationInfo().name, Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed=mPrefs.edit();
                    Gson gson = new Gson();

                    if(mPrefs.contains("RecordList")){
                        String json = mPrefs.getString("RecordList", null);
                        list = gson.fromJson(json,
                                new TypeToken<List<Record>>(){}.getType());

                        if(list == null){
                            list = new ArrayList<>();
                            list.add(record);
                        } else {
                            list.add(record);
                        }
                    } else {
                        list = new ArrayList<>();
                        list.add(record);
                    }

                    ed.putString("RecordList", gson.toJson(list));
                    ed.commit();
                    Toast.makeText(RecordNew.this,"Record Added",Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e){

                    Toast.makeText(RecordNew.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
