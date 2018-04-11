package com.example.danie.musicstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoritesActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ListView favoritesListView = findViewById(R.id.favorites_list);
        ImageView backButton = findViewById(R.id.favorites_backButton);
        final Intent goBack = new Intent(this, MainActivity.class);

        MusicAdapter favoritesAdapter = new MusicAdapter(this, getData());
        favoritesListView.setAdapter(favoritesAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FavoritesActivity.this, "Going back...", Toast.LENGTH_SHORT).show();
                goBack.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goBack);
            }
        });
    }

    private ArrayList<Music> getData() {
        ArrayList<Music> recentList = new ArrayList<>();

        String song = null, artist = null;
        int musicIcon = 0, playIcon = 0;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            song = bundle.getString("song");
            artist = bundle.getString("artist");
            musicIcon = R.mipmap.ic_library_music_black_24dp;
            playIcon = R.mipmap.ic_play_arrow_black_24dp;
        }

        recentList.add(new Music(song, artist, musicIcon, playIcon));
        return recentList;
    }
}
