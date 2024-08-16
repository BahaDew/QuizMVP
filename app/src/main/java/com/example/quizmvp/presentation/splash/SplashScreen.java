package com.example.quizmvp.presentation.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Chronometer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmvp.R;
import com.example.quizmvp.presentation.main_screen.MainActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    private final long time = System.currentTimeMillis();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.start();
        chronometer.setOnChronometerTickListener(t -> {
            if (System.currentTimeMillis() - time >= 3000) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
