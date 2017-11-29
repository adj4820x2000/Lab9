package com.example.user.myapplication;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class MyReceiver extends Service {
        public IBinder onBind(Intent intent){
            return null;
        }

    @Override
    public void onCreate() {
        new Thread(){
            boolean flag = true;
            int count = 0;

            @Override
            public void run(){
                while (flag){
                    Intent i =new Intent("MyMessage");
                    i.putExtra("background_service", count);
                    sendBroadcast(i);
                    count++;

                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
