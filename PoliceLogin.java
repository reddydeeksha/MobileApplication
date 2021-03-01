package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PoliceLogin extends AppCompatActivity {
    EditText ed1,ed2;
    TextView tx1;
    int counter=3;
    Button b1;
    Button button13;


    public void clicksign(View view){
        if(ed1.getText().toString().equals("12-56789") &&
                ed2.getText().toString().equals("12345")) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();
            Intent intent1=new Intent(this,PoliceNext2.class);
            startActivity(intent1);
        }
        else{
            Toast.makeText(getApplicationContext(), "WrongCredentials",Toast.LENGTH_SHORT).show();

            tx1.setVisibility(View.VISIBLE);
            tx1.setBackgroundColor(Color.WHITE);
            counter--;
            String a=Integer.toString(counter);
            tx1.setText("attempts left: "+a);
            //tx1.setText(Integer.toString(counter));

            if (counter == 0) {
                b1.setEnabled(false);
            }
        }


    }
    public void clickcancel(View view){
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }

    public void clickFunction(View view){
        Intent intent1=new Intent(this,PoliceRegistration.class);
        startActivity(intent1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        ed1=findViewById(R.id.editText4);
        ed2=findViewById(R.id.editText3);
        b1=findViewById(R.id.button2);
        button13=findViewById(R.id.button13);
        tx1=(TextView)findViewById(R.id.textView2);


    }
}
