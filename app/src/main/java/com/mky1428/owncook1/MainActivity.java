package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        getSupportActionBar().setTitle(G.nickname + " 님");
        getSupportActionBar().setSubtitle("환영합니다");

    }

    public void clickMyrecipe(View view) {
        Intent intent = new Intent(this, MyRecipeActivity.class);
        startActivity(intent);
    }

    public void clickRecRecipe(View view){
        Intent intent= new Intent(this, RecMenuSelectActivity.class);
        startActivity(intent);
    }

}