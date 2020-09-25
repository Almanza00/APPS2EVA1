package com.example.eva1_3_frag_din;

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

    public void mostraRojo (View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        RedFragment redFragment = new RedFragment();
        ft.replace(R.id.frmLaytFrag, redFragment);
        ft.commit();
    }
    public void mostrarAzul (View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BlueFragment blueFragment = new BlueFragment();
        ft.replace(R.id.frmLaytFrag, blueFragment);
        ft.commit();
    }
}