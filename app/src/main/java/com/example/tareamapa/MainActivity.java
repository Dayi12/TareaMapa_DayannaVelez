package com.example.tareamapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback{
    RadioButton normal,satelital;
    GoogleMap mapa;
    int tipoVista=4;
    Marker marcador;
    LatLng UTEQ= new LatLng(-1.0126800010428147, -79.46949941234125);
    LatLng HcdMaria= new LatLng(-1.080101660620203, -79.5015185765049);
    List <ListAdapter> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normal=findViewById(R.id.rbtNormal);
        satelital=findViewById(R.id.rbtnSatelital);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        lista=new ArrayList<>();
        lista.add(new ListAdapter("Universidad Técnica Estatal de Quevedo","Dr. Eduardo Díaz Ocampo, PhD.",-1.0118868985242953,-79.46967053595654,"https://www.uteq.edu.ec/images/page/4/logoUTEQoriginal1.png"));
        lista.add(new ListAdapter("Facultad De Ciencias De La Ingeniería","Ing. Washington Alberto Chiriboga Casanova, M.Sc.",-1.0126954583561554,-79.47040546129651,"https://www.uteq.edu.ec/images/page/4/logo_fci.png"));
        lista.add(new ListAdapter("Facultad De Ciencias Empresariales","Ing. Mariela Susana Andrade Arias, PhD.",-1.0121001009149,-79.47024452874945,"https://www.uteq.edu.ec/images/about/logo_fce.jpg"));
        lista.add(new ListAdapter("Unidad De Posgrado","Ing. Roque Vivas, M.Sc.",-1.0132693613721047,-79.46842867325239,"https://www.uteq.edu.ec/images/about/logo_pos.jpg"));
        lista.add(new ListAdapter("Facultad De Ciencias De La Industria Y La Producción","Ing. Sonnia Esther Barzola Miranda, M.Sc.",-1.0809707828078403,-79.50152265295664,"https://www.uteq.edu.ec/images/page/4/logoUTEQoriginal1.png"));
        lista.add(new ListAdapter("Facultad De Ciencias Agropecuarias","Ing. Leonardo Gonzalo Matute, M.Sc.",-1.0811743533848226,-79.50260218892106,"https://www.uteq.edu.ec/images/about/logo_fcamb.jpg"));
    }
    public void selectorNomral(View view){
        if (normal.isChecked()==true){
            mapa.setMapType(2);
            CameraPosition camPos = new CameraPosition.Builder()
                    .target(UTEQ)
                    .zoom(17)
                    .bearing(45)
                    .tilt(70)
                    .build();
            CameraUpdate camUpd3 =
                    CameraUpdateFactory.newCameraPosition(camPos);
            mapa.animateCamera(camUpd3);
        }
    }
    public void selectorSatelital(View view){
        if (satelital.isChecked()==true){
            mapa.setMapType(2);
            CameraPosition camPos = new CameraPosition.Builder()
                    .target(HcdMaria)
                    .zoom(17)
                    .bearing(45)
                    .tilt(70)
                    .build();
            CameraUpdate camUpd3 =
                    CameraUpdateFactory.newCameraPosition(camPos);
            mapa.animateCamera(camUpd3);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.getUiSettings().setZoomControlsEnabled(true);
        for(int i=0;i<lista.size();i++){
            //LatLng UTEQ= new LatLng(-1.0130542111468632, -79.46855806906344);
           LatLng UTEQ= new LatLng(lista.get(i).coorX,lista.get(i).coorY);
            mapa.addMarker(new MarkerOptions().position(UTEQ).draggable(true).title(lista.get(i).facultad).snippet("Decano: "+lista.get(i).decano+"\nUbicacion: "+lista.get(i).coorX+""+lista.get(i).coorY+" ~ "+lista.get(i).img));
            mapa.setInfoWindowAdapter(new UserInfoWindowAdapter(MainActivity.this));
        }
    }
}