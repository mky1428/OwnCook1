package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.tv);

        Animation ani = AnimationUtils.loadAnimation(this, R.anim.appear_logo);
        iv.startAnimation(ani);
        tv.startAnimation(ani);

    }
}