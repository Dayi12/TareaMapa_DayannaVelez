package com.example.tareamapa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;


public class UserInfoWindowAdapter  implements GoogleMap.InfoWindowAdapter {
    Context context;
    public UserInfoWindowAdapter(Context context){
        this.context=context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View infView=LayoutInflater.from(context).inflate(R.layout.windows_info,null);
        ImageView img=infView.findViewById(R.id.imageView3);
        TextView nombre=infView.findViewById(R.id.txtNombre);
        TextView decano=infView.findViewById(R.id.txtDecano);
        nombre.setText(marker.getTitle());
        String[] separador=marker.getSnippet().split("~");
        decano.setText(separador[0]);

        /*Glide.with(infView)
                .load("https://www.uteq.edu.ec/images/about/logo_ued.jpg")
                .circleCrop()
                .into(img);*/
        Picasso.get().load(separador[1].replace(" ","")).into(img);

        System.out.println("imagen "+ separador[1].replace(" ",""));

        return infView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
