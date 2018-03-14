package com.example.lecture2_wizardapp_try2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputAddress extends BaseActivity {
    public static final String MESSAGE_NAME = "MESSAGE_NAME";
    public static final String MESSAGE_ADDRESS = "MESSAGE_ADDRESS";
    String messageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_address);

        Intent intent = getIntent();
        messageName = intent.getStringExtra(MainActivity.MESSAGE_NAME);
    }

    public void sendMessage_Address(View view) {
        Intent intent = new Intent(this, InputTimeDate.class);
        EditText editText = (EditText) findViewById(R.id.EnteredAdress);
        String message = editText.getText().toString();
        intent.putExtra(MESSAGE_NAME, messageName);
        intent.putExtra(MESSAGE_ADDRESS, message);
        currentUser.address = message.toString();
        db.userDao().update(currentUser);
        startActivity(intent);
    }
}
