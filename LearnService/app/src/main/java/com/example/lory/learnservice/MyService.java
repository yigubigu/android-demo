package com.example.lory.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new Binder() ;

    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
       /* new Thread() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("service is running");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();*/

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("service detroy");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("service create");
    }
}
