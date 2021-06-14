package com.alangravesinventory;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG = "demo";
    ListView listView;
    ArrayList<User> users = new ArrayList<>();
    UserAdapter adapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test entries to check UI
        users.add(new User("Bananas", 29));
        users.add(new User("Strawberries", 19));
        users.add(new User("Apples", 32));
        users.add(new User("Watermelons", 44));
        users.add(new User("Carrots", 27));

        listView = findViewById(R.id.listView);
        adapter = new UserAdapter(this, R.layout.user_row_item, users);
        listView.setAdapter(adapter);


    }
}