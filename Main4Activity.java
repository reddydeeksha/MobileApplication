package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main4Activity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1,b2;
    TextView tx1;
    FirebaseAuth firebaseAuth;
    int counter=3;

    public void click(View view) {
        /*String val=ed1.getEditText().getText().toString();
        String noWhitespace="\\A\\w{4,20}\\z";
        if(val.length()>=15){
            ed1.setError("username too long");
        }*/
        if(ed1.getText().toString().equals("admin@gmail.com") &&
                ed2.getText().toString().equals("12345")) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();
            Intent intent1=new Intent(this,Main6Activity.class);
            startActivity(intent1);
        }
        else{
            Toast.makeText(getApplicationContext(), "WrongCredentials",Toast.LENGTH_SHORT).show();

            tx1.setVisibility(View.VISIBLE);
            tx1.setBackgroundColor(Color.WHITE);
            counter--;
            String a=Integer.toString(counter);
            tx1.setText("attempts left: "+a);
            //tx1.setText("attempts":Integer.toString(counter));
            //tx1.setText("attempts"Integer.toString(counter));

            if (counter == 0) {
                b1.setEnabled(false);
            }
        }


    }
        /*if (ed1.getText().toString().equals("admin@gmail.com") &&
                ed2.getText().toString().equals("12345")) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...", Toast.LENGTH_SHORT).show();
           /* firebaseAuth.createUserWithEmailAndPassword(ed1.getText().toString(), ed2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {*/
                    //if (task.isSuccessful()) {
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(Main4Activity.this, Main6Activity.class));
                   // }


                    /*Intent intent1=new Intent(this,Main6Activity.class);
                    startActivity(intent1);*/


                    /*else {
                        Toast.makeText(getApplicationContext(), "WrongCredentials", Toast.LENGTH_SHORT).show();

                        tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.WHITE);
                        counter--;
                        tx1.setText(Integer.toString(counter));

                        if (counter == 0) {
                            b1.setEnabled(false);
                        }
                    }


                }
            });
        }
    }*/

    public void clickcancel(View view){
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
       //startActivity(new Intent(Main4Activity.this, MainActivity.class));
    }
    public void clickFunction (View view){
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
        //startActivity(new Intent(Main4Activity.this, Main3Activity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText6);
        ed2=(EditText)findViewById(R.id.editText7);
        b2=(Button)findViewById(R.id.button2);
        tx1=(TextView)findViewById(R.id.textView2);
        //tx1.setVisibility(View.GONE);

    }
}
