package com.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG = "demo";
    ListView listView;
    ArrayList<User> users = new ArrayList<>();
    ArrayAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("Bob Smith", 45));
        users.add(new User("Alice Brown", 25));
        users.add(new User("Bill Green", 21));
        users.add(new User("Tom White", 28));
        users.add(new User("Eve Green", 30));

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, users);
        listView.setAdapter(adapter);



    }
}