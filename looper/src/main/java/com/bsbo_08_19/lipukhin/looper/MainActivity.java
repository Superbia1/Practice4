package com.bsbo_08_19.lipukhin.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyLooper myLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", "mirea");
            msg.setData(bundle);
            if (myLooper != null) {
                myLooper.handler.sendMessage(msg);
            }
        });
    }
}