package com.example.eva1_4_frag_parametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void crearFrag(View v){
        //TRANSACCION
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //CREAR EL FRAGMENTO
        ParamFragment paramFragment = ParamFragment.newInstance("Hola mundo","Valores asignados al fragmento");
        //REEMPLAZAR NUESTRO LAYOUT CON EL FRAGMENTO
        ft.replace(R.id.frmLytFrag,paramFragment);
        //HACER UN COMMIT
            ft.commit();

    }

}