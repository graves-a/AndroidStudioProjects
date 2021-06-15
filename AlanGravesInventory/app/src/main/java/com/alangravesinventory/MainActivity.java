package com.alangravesinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG = "demo";
    ArrayList<Item> items = new ArrayList<>();
    LinearLayoutManager layoutManager;
    ItemRecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new Item("Bananas", 25));
        items.add(new Item("Watermelons", 30));
        items.add(new Item("Apples", 40));
        items.add(new Item("Strawberries", 45));
        items.add(new Item("Coconuts", 50));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemRecyclerViewAdapter(items);
        recyclerView.setAdapter(adapter);


    }
}