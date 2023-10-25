package com.example.taller2maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.videoView);
        String Video = "android.resource://"+getPackageName()+"/"+R.raw.video;//se obtiene la referencia al video con su ID
        // se crea una cadena que representa la ubicacion del recurso
        Uri uri = Uri.parse(Video);//se crea un objeto uri a partir de la cadena
        videoView.setVideoURI(uri);//se establece la fuente del video

        //se crea un objeto que proporciona los controles de reproduccion
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);//se asigna que los controles de reproduccion sean visibles y funcionales
        mediaController.setAnchorView(videoView);//se especifica la vista a la qye se ancalran los controles
        videoView.setScaleX(1.0f);
        videoView.setScaleY(1.0f);

    }
    public void goBack (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}