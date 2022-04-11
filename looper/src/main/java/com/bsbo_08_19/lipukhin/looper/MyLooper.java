package com.bsbo_08_19.lipukhin.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
public class MyLooper  extends Thread {
    private int number = 0;
    Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.d("MyLooper", "Мне " + number + " лет, я работаю в " + msg.getData().getString("KEY"));
                number++;
            }
        };
        Looper.loop();
    }
}
