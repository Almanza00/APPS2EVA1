package com.example.rep_3_runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtUno;
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //Aqui modificamos la interfaz grafica
            txtUno.append("Hola mundo cruel\n");
        }
    };

    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            int i = 0;
            while(i < 10){
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUno = findViewById(R.id.txtUno);
        thread.start();

    }
}