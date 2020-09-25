package com.example.eva1_11_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WeatherAdapter extends ArrayAdapter<Weather> {
    //private Weather[] objects;
    private List<Weather> objects;
    private Context context;
    private int resource;
    public WeatherAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){//PRIMERA VEZ, HAY QUE CREAR LAYOUT
            convertView = ((Activity)context).getLayoutInflater().inflate(resource, parent, false);

        }
//Hay que recuperar los componentes
        ImageView imgW;
        TextView city, temp, desc;
        imgW = convertView.findViewById(R.id.imgW);
        city = convertView.findViewById(R.id.city);
        temp = convertView.findViewById(R.id.temp);
        desc = convertView.findViewById(R.id.desc);
        //CONEXION
        Weather weather = objects.get(position);

        imgW.setImageResource(weather.getImage());
        city.setText(weather.getCity());
        temp.setText(""+weather.getTemp());
        desc.setText(weather.getDesc());


        return convertView;

    }
}
