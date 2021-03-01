package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoliceNext2 extends AppCompatActivity {
    Button btnnotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_next2);
        btnnotification = findViewById(R.id.button14);
        btnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoliceNext2.this, Policeviewnotification.class);
                startActivity(intent);
            }
        });
    }
}
