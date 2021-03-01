
package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class Main8Activity<Firebase> extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button btn;
    Button btn1;
    Member m;
    int id=0;
    public static final String Firebase_Server_URL="https://mobileapp-62abf.firebaseio.com/";

    Firebase firebase;
    DatabaseReference reff;
    public void clickLogout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ed1=findViewById(R.id.editText4);
        ed2=findViewById(R.id.editText13);
        ed3=findViewById(R.id.editText9);
        ed4=findViewById(R.id.editText11);
        ed5=findViewById(R.id.editText14);
        ed6=findViewById(R.id.editText15);
        btn=findViewById(R.id.button10);
        m=new Member();
        reff=FirebaseDatabase.getInstance().getReference().child("user");
        reff.addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String value = dataSnapshot.getValue(String.class);
                //System.out.println("Value is " + value);
                //DataSnapshot dataSnapshot = null;
                if (dataSnapshot.exists()) {
                    id = (int) dataSnapshot.getChildrenCount();

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String email=ed1.getText().toString();
                if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please fill",Toast.LENGTH_LONG).show();
                }
                else{
                    notification();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            String n1 = ed1.getText().toString();
            String n2 = ed2.getText().toString();
            String n3 = ed3.getText().toString();
            String n4 = ed4.getText().toString();
            String n5 = ed5.getText().toString();
            String n6 = ed6.getText().toString();
            m.setabout_the_incident(n1);
            //m.setText2(n2);
            m.setplace_of_incident(n3);
            m.settype_of_incident(n4);
            m.setdate_and_time_of_incident(n5);
            m.setname_of_person(n6);
            //reff.setValue(m);
            reff.child(String.valueOf(id)).setValue(m);
            Toast.makeText(getApplicationContext(),"inserted data",Toast.LENGTH_LONG).show();
            if ((n1.isEmpty() && n2.isEmpty() && n3.isEmpty() && n4.isEmpty() && n5.isEmpty() && n6.isEmpty())) {
                Toast.makeText(Main8Activity.this, "Fields are Empty.!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Main8Activity.this, "Your Case has been registered", Toast.LENGTH_SHORT).show();
            }
                if(n1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please fill",Toast.LENGTH_LONG).show();
                }
                else{
                    m.setabout_the_incident(ed1.getText().toString());
                    reff.child(String.valueOf(id)).setValue(m);
                    //reff.setValue(m);
                }
        }
    });
    }
    private void notification(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"n").setContentText("demoapp").
                setSmallIcon(R.drawable.ic_notifications_black_24dp).setAutoCancel(true).setContentText("New data is added");
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(999,builder.build());
    }
}



