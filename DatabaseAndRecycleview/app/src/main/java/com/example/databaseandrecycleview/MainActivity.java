package com.example.databaseandrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView rvNumber;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNumber = findViewById(R.id.recycle_number);
        rvNumber.setLayoutManager(new LinearLayoutManager(this));

        final NameAdapter adapter=new NameAdapter();


        rvNumber.setAdapter(adapter);


        final UserDatabase db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "database-name").build();


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User("3d");
                db.userDao().insert(user);
                List<User> users = db.userDao().getAll();
                final List<String> nameData1=new ArrayList<>();
                for(int i = 0;i<users.size();i++){
                    nameData1.add(users.get(i).name);
                }
                adapter.data=nameData1;
                return null;
            }
        }.execute();

    }
}