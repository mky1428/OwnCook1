package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void clickKakaoLogin(View view) {
    }

    public void clickGoogleLogin(View view) {
    }

    public void clickStart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}