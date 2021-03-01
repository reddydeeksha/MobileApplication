package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button8;
    private Button button16;
    private Button button18;
    public void clickCitizen(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public void clickPolice(View view){
        Intent intent1=new Intent(this,PoliceRegistration.class);
        startActivity(intent1);
    }
    public void clickAdmin(View view){
        Intent intent2=new Intent(this,AdminPage.class);
        startActivity(intent2);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"connectedtodatabase",Toast.LENGTH_LONG).show();
        button8=findViewById(R.id.button);
        button16=findViewById(R.id.button8);
        button18=findViewById(R.id.button18);


    }
}

