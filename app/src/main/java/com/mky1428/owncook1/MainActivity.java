package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyFragment1 myFragment1;
    MyFragment2 myFragment2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myFragment1 = (MyFragment1) fragmentManager.findFragmentById(R.id.frag1);
        myFragment2 = (MyFragment2) fragmentManager.findFragmentById(R.id.frag2);

        
        getSupportActionBar().setTitle(G.nickname + " 님");
        getSupportActionBar().setSubtitle("환영합니다");

    }

    public void clickMyrecipe(View view) {
        Intent intent = new Intent(this, MyRecipeActivity.class);
        startActivity(intent);
    }
}