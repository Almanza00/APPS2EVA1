package com.example.rep_5_segunda_parte_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 TextView txtUno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUno = findViewById(R.id.txtUno);

        BroadcastReceiver breceiver = new MiBrodacastReceiver();
        IntentFilter intentFilter = new IntentFilter("MI SERVICIO");
        registerReceiver(breceiver,intentFilter);
    }
    class MiBrodacastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //Procesamos el mensaje
          txtUno.append(intent.getStringExtra("ENVIADOS"));
        }
    }
}