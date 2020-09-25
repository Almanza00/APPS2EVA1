package com.example.eva1_2_comunicacion_fragmentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1. Recuperar los fragmentos
    ListFragment lista;
    DataFragment datos;

    //2. Acceder a los fragmentos
    //Hay un metod que se ejecuta cuando un fragmento se vincula
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ListFragment.class)
            lista = (ListFragment)fragment;
        else if(fragment.getClass() == DataFragment.class)
            datos = (DataFragment)fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //Interfaz de comunicacion
    public void onMessageFromFragToMain(String sender, String param){
        if(sender.equals("LISTA")){//Recibimos la informacion
            //Enviar al fragmento data
            datos.onMessageFromMainToFrag(param);
        }else if(sender.equals("DATA")){
            //Imprimir mensaje
            Toast.makeText(this,param,Toast.LENGTH_LONG).show();
        }
    }
}