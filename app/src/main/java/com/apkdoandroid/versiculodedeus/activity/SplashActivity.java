package com.apkdoandroid.versiculodedeus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.apkdoandroid.versiculodedeus.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirAutenticacao();
            }
        },3000);

    }
    private void abrirAutenticacao(){
        finish();
        Intent i = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(i);
    }
}