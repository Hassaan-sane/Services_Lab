package com.example.sane.services_lab;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this, "ON STRT Command", Toast.LENGTH_SHORT).show();

        Thread thread = new Thread() {

            @Override
            public void run() {

                for (int i = 1; i <= 20; i++) {
                    try {
                        sleep(500);
                        Toast.makeText(MyService.this, "In THread"+i, Toast.LENGTH_SHORT).show();
                        ;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        };
        thread.start();

        //Toast.makeText(this, "ON STRT COmmand", Toast.LENGTH_SHORT).show();

        return START_STICKY;


    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
}
