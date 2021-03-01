package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoliceNext extends AppCompatActivity {
    Button btnnotification;
    Button btnupdate;
    /*public void clickchecknotification(View view) {
        Intent intent = new Intent(this, Policeviewnotification.class);
        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_next);
        btnnotification= findViewById(R.id.button14);
        btnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoliceNext.this, Main6Activity.class);
                startActivity(intent);
            }
        });
    }
}
