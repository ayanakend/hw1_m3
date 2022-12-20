package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText editTextSubject,editTextMessage,editTextEmail;
    Button send;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSubject=(EditText)findViewById(R.id.heading);
        editTextMessage=(EditText)findViewById(R.id.message);
        editTextEmail=(EditText)findViewById(R.id.mail);

        send=(Button)findViewById(R.id.button1);
        send.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String heading=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();
                String to=editTextEmail.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, heading);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}