package com.example.lecture2_wizardapp_try2.database;

/**
 * Created by hgdru on 12-03-2018.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey
    public int uid;
    public String name;
    public String address;
    public long dateOfBirth;

}

