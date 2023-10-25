package com.example.taller2maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Maps extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{

    EditText txtlatitud, txtlongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        txtlatitud = findViewById(R.id.txtLatitud);
        txtlongitud = findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtlatitud.setText(""+latLng.latitude);
        txtlongitud.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtlongitud.setText("" + latLng.longitude);
        txtlatitud.setText("" + latLng.latitude);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this::onMapClick);//

        List<Direcciones> locations = new ArrayList<>();
        locations.add(new Direcciones(new LatLng(-18.483212600790978, -70.31041831879779),"ARICA. 18 de Septiembre 1191"));
        locations.add(new Direcciones(new LatLng(-20.23965540359343, -70.144867971164),"IQUIQUE. Av. Héroes de la Concepción 2885"));
        locations.add(new Direcciones(new LatLng(-23.634584045169706, -70.39406333217275),"ANTOFAGASTA. Av. Iquique 3991"));
        locations.add(new Direcciones(new LatLng(-29.76411241547793, -71.29267048003398),"LA SERENA. Ruta 5 Norte 1068"));
        locations.add(new Direcciones(new LatLng(-33.03754230094441, -71.52212563304559),"VIÑA DEL MAR. 1 Nte. 3041"));
        locations.add(new Direcciones(new LatLng(-33.44840576169196, -70.66073063978168),"SANTIAGO. Av. Ejército Libertador 146"));
        locations.add(new Direcciones(new LatLng(-35.42864771613577, -71.67291721942158),"TALCA. Av. Carlos Schorr 255"));
        locations.add(new Direcciones(new LatLng(-36.82623459381613, -73.06162837963693),"CONCEPCIÓN. Arturo Prat 879"));
        locations.add(new Direcciones(new LatLng(-37.47192844782211, -72.35396271638434),"LOS ÁNGELES. Manuel Rodríguez 140"));
        locations.add(new Direcciones(new LatLng(-38.734579690924974, -72.60200312536959),"TEMUCO. Manuel Rodriguez 060"));
        locations.add(new Direcciones(new LatLng(-39.81728323455412, -73.23311686702574),"VALDIVIA. Av. Ramón Picarte 1160"));
        locations.add(new Direcciones(new LatLng(-40.5716847536876, -73.13769376099003),"OSORNO. Los Carrera 753"));
        locations.add(new Direcciones(new LatLng(-41.47268505043663, -72.92884273156733),"PUERTO MONTT. Buena Vecindad 91"));

        for (Direcciones direcciones : locations){
            LatLng location = direcciones.getDirectorio();
            String tittle = direcciones.getTitulo();

            mMap.addMarker(new MarkerOptions().position(location).title(tittle));
        }
    }
    public void goVideo (View view){
        Intent intent = new Intent(this, Video.class);
        startActivity(intent);
    }
}