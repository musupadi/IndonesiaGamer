package com.destiny.indonesiagamer.Activity.ui.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.destiny.indonesiagamer.Method.Destiny;
import com.destiny.indonesiagamer.R;

public class DeskripsiGame extends AppCompatActivity {
    String NAMA,DESKRIPSI,PLATFORM,GAMBAR,YOUTUBE,WEBSITE,GENRE;

    TextView Platform,Genre,Deskripsi;
    Button Trailer,Website,Favorit;
    ImageView gambar;
    Destiny destiny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_game);

        Intent intent = getIntent();
        NAMA = intent.getExtras().getString("NAMA");
        DESKRIPSI = intent.getExtras().getString("DESKRIPSI");
        PLATFORM = intent.getExtras().getString("PLATFORM");
        GAMBAR = intent.getExtras().getString("GAMBAR");
        YOUTUBE = intent.getExtras().getString("YOUTUBE");
        WEBSITE = intent.getExtras().getString("WEBSITE");
        GENRE = intent.getExtras().getString("GENRE");

        getSupportActionBar().setTitle(NAMA);
        Platform = findViewById(R.id.tvPlatform);
        Genre = findViewById(R.id.tvGenre);
        Deskripsi = findViewById(R.id.tvDeskripsi);
        Trailer = findViewById(R.id.btnTrailer);
        Website = findViewById(R.id.btnWebsite);
        Favorit = findViewById(R.id.btnFavorit);
        gambar = findViewById(R.id.ivGambar);

        Platform.setText(PLATFORM);
        Genre.setText(GENRE);
        Deskripsi.setText(DESKRIPSI);
        Glide.with(this)
                .load(GAMBAR)
                .into(gambar);

        Trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny = new Destiny();
                Intent i = new Intent(DeskripsiGame.this, TrailerGameActivity.class);
                i.putExtra("YOUTUBE",destiny.GetIDYoutube(YOUTUBE));
                startActivity(i);
            }
        });
        Website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEBSITE));
                    startActivity(browserIntent);
                }catch (Exception e){
                    try {
                        Toast.makeText(DeskripsiGame.this, "Link Tidak Valid", Toast.LENGTH_SHORT).show();
                    }catch (Exception ex){

                    }
                }
            }
        });
        Favorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DeskripsiGame.this, "Fitur ini Sedang dikerjakan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}