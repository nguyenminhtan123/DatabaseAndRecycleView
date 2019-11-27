package com.example.databaseandrecycleview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    String name;

    public User(String name) {
        this.name=name;
    }
}

