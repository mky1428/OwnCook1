package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EntRecipeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent_recipe_list);

        getSupportActionBar().setTitle("모두의레시피");


    }
}