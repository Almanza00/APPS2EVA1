package com.example.rep_5_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Intent Miintento;
    Thread thread;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MI SERVICIO","ON CREATE");
    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("MI SERVICIO",intent.getStringExtra("DATO"));
        thread =  new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(1000);
                        //Log.wtf("MI SERVICIO", "THREAD");
                        Miintento = new Intent("MI SERVICIO");
                        Miintento.putExtra("ENVIADOS","ESCUCHANDO EL SERVICIO");
                        sendBroadcast(Miintento);
                        //Miintento.putExtra
                        sendBroadcast(Miintento);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MI SERVICIO","ON DESTROY");
        thread.interrupt();
    }
}
