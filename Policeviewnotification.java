package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Policeviewnotification extends AppCompatActivity {
    Button btnfetch;
    Member m;
    //TextView fetchText;
    TextView about_the_incident;
    TextView place_of_incident;
    TextView type_of_incident;
    TextView date_and_time_of_incident;
    TextView name_of_person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policeviewnotification);
        btnfetch = (Button) findViewById(R.id.button19);
        about_the_incident = (TextView) findViewById(R.id.textView9);
        place_of_incident = (TextView) findViewById(R.id.textView11);
        type_of_incident = (TextView) findViewById(R.id.textView12);
        date_and_time_of_incident = (TextView) findViewById(R.id.textView13);
        name_of_person = (TextView) findViewById(R.id.textView14);
        //fetchText = (TextView) findViewById(R.id.textview6);
        //fetchText = (TextView) findViewById(R.id.textview6);
        btnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference demref;
                demref = FirebaseDatabase.getInstance().getReference().child("user");
                demref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //String m1=snapshot.getValue(Member.class).place_of_incident;

                        Member m=(Member)snapshot.getValue(Member.class);
                        //System.out.println(m.getabout_the_incident());
                        String m1 = m.getabout_the_incident();
                        String message = m.getplace_of_incident();
                        String m2 = m.gettype_of_incident();
                        String m3 = m.getdate_and_time_of_incident();
                        String m4 = m.getname_of_person();
                        //ChatMessage message=snapshot.getValue(ChatMessage.class);
                        about_the_incident.setText(m1);
                        place_of_incident.setText(message);
                        type_of_incident.setText(m2);
                        date_and_time_of_incident.setText(m3);
                        name_of_person.setText(m4);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Policeviewnotification.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
