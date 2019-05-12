package com.example.dailyhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FirstAidDiabetes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_diabetes);

        //Setting Views
        final ImageView backArrowButton = findViewById(R.id.icon_back_arrow);

        //Setting Navigation
        //Back Arrow
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backArrowButton.setColorFilter(R.color.colorDBlue);
                finish();
            }
        });
    }
}
