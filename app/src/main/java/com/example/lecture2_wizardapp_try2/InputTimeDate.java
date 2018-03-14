package com.example.lecture2_wizardapp_try2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputTimeDate extends BaseActivity {
    public static final String MESSAGE_NAME = "MESSAGE_NAME";
    public static final String MESSAGE_ADDRESS = "MESSAGE_ADDRESS";
    public static final String MESSAGE_DATE = "MESSAGE_DATE";
    String messageName;
    String messageAddress;
    private DatePicker dpDateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ACTIVITY:", "InputTimeDate onCreate");
        setContentView(R.layout.activity_input_time_date);

        dpDateOfBirth = (DatePicker) findViewById(R.id.datePicker);

        Intent intent = getIntent();
        messageName = intent.getStringExtra(InputAddress.MESSAGE_NAME);
        messageAddress = intent.getStringExtra(InputAddress.MESSAGE_ADDRESS);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ACTIVITY:", "InputTimeDate onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ACTIVITY:", "InputTimeDate onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ACTIVITY:", "InputTimeDate onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ACTIVITY:", "InputTimeDate onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ACTIVITY:", "InputTimeDate onDestroy");
    }

    public void sendMessage_Date(View view) {
        Intent intent = new Intent(this, ViewResults.class);

        int   day  = dpDateOfBirth.getDayOfMonth();
        int   month= dpDateOfBirth.getMonth();
        int   year = dpDateOfBirth.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = sdf.format(calendar.getTime());

        intent.putExtra(MESSAGE_DATE, formatedDate);
        intent.putExtra(MESSAGE_NAME, messageName);
        intent.putExtra(MESSAGE_ADDRESS, messageAddress);

        currentUser.dateOfBirth = calendar.getTimeInMillis() / 1000;
        db.userDao().update(currentUser);

        startActivity(intent);
    }
}
