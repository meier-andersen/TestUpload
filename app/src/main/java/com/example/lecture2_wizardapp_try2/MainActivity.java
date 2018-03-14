package com.example.lecture2_wizardapp_try2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends BaseActivity {
    public static final String MESSAGE_NAME = "MESSAGE_NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, InputAddress.class);
        EditText editText = (EditText) findViewById(R.id.InputAdress);
        String message = editText.getText().toString();
        intent.putExtra(MESSAGE_NAME, message);
        currentUser.name =  message.toString();
        db.userDao().update(currentUser);
        startActivity(intent);
    }
}
