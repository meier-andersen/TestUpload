package com.example.lecture2_wizardapp_try2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lecture2_wizardapp_try2.database.AppDatabase;
import com.example.lecture2_wizardapp_try2.database.User;

/**
 * Created by hgdru on 12-03-2018.
 */

public class BaseActivity extends AppCompatActivity {

    protected AppDatabase db;
    protected User currentUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getAppDatabase(this);
        if(db.userDao().countUsers() == 0){
            currentUser = new User();
            currentUser.uid = 1;
            currentUser.address = "";
            currentUser.dateOfBirth = 0;
            currentUser.name = "";
            db.userDao().insert(currentUser);
        }
        else{
            currentUser = db.userDao().getUser();
            Log.i("Database entry", currentUser.name);
            Log.i("Database entry", currentUser.address);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
