package com.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG = "demo";
    ArrayList<User> users = new ArrayList<>();
    LinearLayoutManager layoutManager;
    UserRecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("Bob Smith", 45));
        users.add(new User("Alice Brown", 25));
        users.add(new User("Bill Green", 21));
        users.add(new User("Tom White", 28));
        users.add(new User("Eve Green", 30));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UserRecyclerViewAdapter(users);
        recyclerView.setAdapter(adapter);


    }
}