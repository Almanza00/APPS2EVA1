package com.example.eva1_5_cambio_orientacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout frmLytDetail;
    Intent inDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inDetail = new Intent(this, DetailActivity.class);
    }

    public void onMessageFromFragmentToMain(){
        frmLytDetail = findViewById(R.id.frmLaytDetail);
        if(frmLytDetail != null){//LANSCAPE
            //CREAR DINAMICAMENTE EL FRAGMENTO
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DetailFragment detailFragment = new DetailFragment();
            ft.replace(R.id.frmLaytDetail,detailFragment);
            ft.commit();

        }else{//PORTRAIT
            startActivity(inDetail);
        }
    }
}