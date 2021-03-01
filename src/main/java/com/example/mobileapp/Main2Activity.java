package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button button5;
    private Button button7;

    public void clickRegister(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void clickLogin(View view) {
        Intent intent1 = new Intent(this, Main4Activity.class);
        startActivity(intent1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button5 = findViewById(R.id.button5);
        button7 = findViewById(R.id.button7);
    }
}
        //button5.setOnClickListener(new View.OnClickListener() {
            /*public void onClick(View v) {
                Register();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }*/

   /* public void Register() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void Login() {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }
}*/

