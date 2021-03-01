package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {
    Button button2;
    Button button9;

    public void clickyes(View view) {
        Intent intent = new Intent(this, Main7Activity.class);
        startActivity(intent);
    }

    public void clickno(View view) {
        Intent intent1 = new Intent(this, Main8Activity.class);
        startActivity(intent1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button2 = findViewById(R.id.button5);
        button9 = findViewById(R.id.button7);
    }
}
