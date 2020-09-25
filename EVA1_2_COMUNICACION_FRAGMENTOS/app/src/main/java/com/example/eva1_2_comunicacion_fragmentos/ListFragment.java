package com.example.eva1_2_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    //DATOS DE LA LISTA
    String[] datos = {"Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio"
            ,"Julio"
            ,"Agosto"
            ,"Septiembre"
            ,"Octubre",
            "Noviembre",
            "Diciembre"};
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
        FrameLayout frameLayout = (FrameLayout)inflater.inflate(R.layout.fragment_list, container, false);
        //Aqui llenamos la lista
        ListView lstViewDatos;
        lstViewDatos = frameLayout.findViewById(R.id.lstViewDatos);
        lstViewDatos.setAdapter(new ArrayAdapter<>(main,android.R.layout.simple_list_item_1,datos));

        //----------------------
        lstViewDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                main.onMessageFromFragToMain("LISTA",datos[i]);

            }
        });


        return frameLayout;
    }
}