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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {
    EditText FirstName;
    EditText LastName;
    EditText EmailAddress;
    EditText password;
    EditText ConfirmPassword;
    FirebaseAuth mFirebaseAuth;
    //DatabaseReference reff;
    Member m;

    Button button3;
    Button button6;

    public void direct(View view){
        String n1 = FirstName.getText().toString();
        String n2=LastName.getText().toString();
        String em = EmailAddress.getText().toString();
        String pass = password.getText().toString();
       // String conpass=ConfirmPassword.getText().toString();
        if (n1.isEmpty()) {
            FirstName.setError("please enter a valid name");
            FirstName.requestFocus();
        }
        else if(n2.isEmpty()){
            LastName.setError("please enter a valid name");
            LastName.requestFocus();
        }
        else if (em.isEmpty()) {
            EmailAddress.setError("please enter your email");
            EmailAddress.requestFocus();
        }
        else if (pass.isEmpty()) {
            password.setError("please enter your password");
            password.requestFocus();
        }
        else if (em.isEmpty() && pass.isEmpty()) {
            Toast.makeText(Main3Activity.this, "Fields Are Empty1!", Toast.LENGTH_SHORT).show();
        }
        /*else if(!(conpass.equals("pass"))){
            Toast.makeText(Main3Activity.this, "Password doesnot match", Toast.LENGTH_SHORT).show();
        }*/
        else if (!(em.isEmpty() && pass.isEmpty())) {
            mFirebaseAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener(Main3Activity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                       // Toast.makeText(Main3Activity.this, "fields are empty!", Toast.LENGTH_SHORT).show();
                    //}
                    //else {
                        startActivity(new Intent(Main3Activity.this, Main5Activity.class));
                    }
                }

            });
        }

        else {
            Toast.makeText(Main3Activity.this, "Error Ocurred!", Toast.LENGTH_SHORT).show();
        }

    }


        /*Intent intent1=new Intent(this,Main5Activity.class);
        startActivity(intent1);*/
    public void clickFunction(View view){
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FirstName = findViewById(R.id.editText);
        LastName = findViewById(R.id.editText5);
        EmailAddress = findViewById(R.id.editText2);
        FirstName = findViewById(R.id.editText);
        password = findViewById(R.id.editText3);
        ConfirmPassword=findViewById(R.id.editText8);
        button3 = findViewById(R.id.button3);
        button6 = findViewById(R.id.button6);
        mFirebaseAuth=FirebaseAuth.getInstance();
                //firebaseAuth = FirebaseAuth.getInstance();
    }
}
