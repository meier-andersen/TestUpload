package com.example.lecture2_wizardapp_try2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewResults extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String messageName = intent.getStringExtra(InputTimeDate.MESSAGE_NAME);
        TextView textView = findViewById(R.id.EnteredName);
        textView.setText(messageName);

        String messageAddress = intent.getStringExtra(InputTimeDate.MESSAGE_ADDRESS);
        TextView textView2 = findViewById(R.id.EnteredAddress);
        textView2.setText(messageAddress);

        String messageDate = intent.getStringExtra(InputTimeDate.MESSAGE_DATE);
        TextView textView3 = findViewById(R.id.EnteredDate);
        textView3.setText(messageDate);
    }
}
