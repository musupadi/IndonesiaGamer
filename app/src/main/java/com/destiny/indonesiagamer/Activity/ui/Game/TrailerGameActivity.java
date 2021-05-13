package com.destiny.indonesiagamer.Activity.ui.Game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.destiny.indonesiagamer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class TrailerGameActivity extends AppCompatActivity {
    String YOUTUBE;
    YouTubePlayerView FajarKontol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_game);
        Intent intent = getIntent();
        YOUTUBE = intent.getExtras().getString("YOUTUBE");
        FajarKontol = findViewById(R.id.youtube);
        getLifecycle().addObserver(FajarKontol);
        FajarKontol.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = YOUTUBE;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        FajarKontol.enterFullScreen();
        FajarKontol.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            @Override
            public void onYouTubePlayerEnterFullScreen() {
                onBackPressed();
            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                onBackPressed();
            }
        });
    }
}