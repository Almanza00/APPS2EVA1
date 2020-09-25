package com.example.rep_1_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtUno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUno = findViewById(R.id.txtUno);
        MiClaseAsincrona mcaPrueba = new MiClaseAsincrona();
        mcaPrueba.execute(1,10,1000);
    }

    class MiClaseAsincrona extends AsyncTask<Integer, String, Double> {

        @Override
        protected Double doInBackground(Integer... integers) {
            int i = integers[0];//Inicio
            while(i<= integers[1]){//Final
                try {
                    Thread.sleep(integers[2]);
                    publishProgress("Hola k ase");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                i++;
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {

            super.onProgressUpdate(values);
            txtUno.append(values[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            txtUno.append("INICIO DEL HILO");
        }
    }
}