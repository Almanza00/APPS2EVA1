package com.example.eva1_2_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataFragment#} factory method to
 * create an instance of this fragment.
 */
public class DataFragment extends Fragment {
    TextView txtViewDatos;
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //Se crea el layout
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.fragment_data, container, false);
        Button btnDatos = linearLayout.findViewById(R.id.btnData);
        txtViewDatos = linearLayout.findViewById(R.id.txtViewDatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragToMain("Data","Mensaje del fragmento de datos");
            }
        });
        return linearLayout;
    }
    //Interfaz de comunicacion
    public void onMessageFromMainToFrag(String param){
        txtViewDatos.setText(param);
    }

}