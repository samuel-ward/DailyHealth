package com.example.dailyhealth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailyhealth.ui.login.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordIntro extends AppCompatActivity {

    private ListView recordList;
    private RecordAdapter adapter;
    private ArrayList<Record> list;
    private User user;

    public class RecordAdapter extends ArrayAdapter<Record> {
        public RecordAdapter(Context context, ArrayList<Record> records) {
            super(context, 0, records);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Record record = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.record, parent, false);
            }
            // Lookup view for data population
            TextView date = (TextView) convertView.findViewById(R.id.lbl_date);
            TextView title = (TextView) convertView.findViewById(R.id.lbl_title);
            TextView details = (TextView) convertView.findViewById(R.id.lbl_details);
            // Populate the data into the template view using the data object
            date.setText(record.getDate());
            title.setText(record.getTitle());
            details.setText(record.getDetails());
            // Return the completed view to render on screen
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_intro);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);
        final Button newRecordButton = findViewById(R.id.btn_add_record);
        recordList = findViewById(R.id.lv_records);

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                finish();
            }
        });

        //Add New
        newRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecordIntro.this, RecordNew.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume(){

        super.onResume();

        //Setting Variables
        user = user.getInstance();
        try{
            list = user.getRecordList();

            //Populating List View
            Collections.reverse(list);
            RecordAdapter adapter = new RecordAdapter(this, list);
            recordList.setAdapter(adapter);
        }catch(Exception e){
            Toast.makeText(RecordIntro.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

        /*Separated Records
        SharedPreferences mPrefs=getSharedPreferences(getApplicationInfo().name, Context.MODE_PRIVATE);

        if(mPrefs.contains("RecordList")){

            try{
                Gson gson = new Gson();
                String json = mPrefs.getString("RecordList", null);
                list = gson.fromJson(json,
                        new TypeToken<List<Record>>(){}.getType());

                //Populating List View
                Collections.reverse(list);
                RecordAdapter adapter = new RecordAdapter(this, list);
                recordList.setAdapter(adapter);
            }catch(Exception e){
                Toast.makeText(RecordIntro.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }*/
    }
}
