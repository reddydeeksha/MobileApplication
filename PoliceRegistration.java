package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PoliceRegistration extends AppCompatActivity {
    EditText FirstName;
    EditText LastName;
    EditText editText16;
    EditText editText17;
    EditText password;
    EditText ConfirmPassword;
    Button button11;
    Button button12;
    FirebaseAuth mFirebaseAuth;

    public void clicksign(View view){
        String n1 = FirstName.getText().toString();
        String em = editText17.getText().toString();
        String pass = password.getText().toString();
        if (n1.isEmpty()) {
            FirstName.setError("please enter a valid name");
            FirstName.requestFocus();
        } else if (pass.isEmpty()) {
            password.setError("please enter your password");
            password.requestFocus();
        }
        else if (em.isEmpty()) {
            editText17.setError("please enter your id number");
            editText17.requestFocus();
        } /*else if (em.isEmpty() && pass.isEmpty()) {
            Toast.makeText(PoliceRegistration.this, "Fields Are Empty1!", Toast.LENGTH_SHORT).show();*/
        else if (!(em.isEmpty() && pass.isEmpty())) {
            mFirebaseAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener(PoliceRegistration.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(PoliceRegistration.this, PoliceNext.class));
                        //Toast.makeText(PoliceRegistration.this, "fields are empty!", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        } else {
            Toast.makeText(PoliceRegistration.this, "Error Ocurred!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickFunction(View view){
        Intent intent1=new Intent(this,PoliceLogin.class);
        startActivity(intent1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_registration);
        FirstName = findViewById(R.id.editText10);
        LastName = findViewById(R.id.editText12);
        editText16 = findViewById(R.id.editText16);
        editText17 = findViewById(R.id.editText17);
        password = findViewById(R.id.editText18);
        ConfirmPassword=findViewById(R.id.editText19);
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);
        mFirebaseAuth=FirebaseAuth.getInstance();
    }
}
