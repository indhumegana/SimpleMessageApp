package com.example.messageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phonenum,usermessage;
    Button sendbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phonenum=findViewById(R.id.phnnum);
        usermessage=findViewById(R.id.message);
        sendbutton=findViewById(R.id.button);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=10;
                String pnum=phonenum.getText().toString();
                String umsg=usermessage.getText().toString();
                if(pnum.length()>10){
                    Toast.makeText(MainActivity.this, "Enter correct phone number", Toast.LENGTH_SHORT).show();
                }
                if(pnum.equals("") || umsg.equals("")){

                    Toast.makeText(MainActivity.this, "fields can't be empty", Toast.LENGTH_SHORT).show();

                }else {
                    try {

                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(pnum, null, umsg, null, null);
                        Toast.makeText(MainActivity.this, "message sent", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {

                        Toast.makeText(MainActivity.this, "message is not sent due to connection issues", Toast.LENGTH_SHORT).show();


                    }
                }

            }
        });






    }
}