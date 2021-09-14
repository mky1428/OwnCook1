package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecMenuTypeActivity extends AppCompatActivity {

    ArrayList<RecItem> items = new ArrayList<>();
    RecyclerView recyclerView;
    RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_menu_type);

        items.add(new RecItem("한식", R.drawable.foodtype1));
        items.add(new RecItem("양식", R.drawable.foodtype2));
        items.add(new RecItem("일식", R.drawable.foodtype3));
        items.add(new RecItem("중식", R.drawable.foodtype4));

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecAdapter(this, items);
        recyclerView.setAdapter(adapter);

    }
}