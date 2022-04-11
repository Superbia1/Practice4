package com.bsbo_08_19.lipukhin.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        Runnable runnable = () -> {
            double days, les;
            days = 5;
            les = 15;
            result = les / days;
        };
        button.setOnClickListener(view -> {
            Thread thread = new Thread(runnable);
            thread.start();
            textView.setText(result + " - среднее количество пар");
        });
    }
}