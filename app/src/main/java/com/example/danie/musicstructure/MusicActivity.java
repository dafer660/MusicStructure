package com.example.danie.musicstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        ListView musicListView = findViewById(R.id.m_list);
        final ImageView backButton = findViewById(R.id.music_backButton);
        final Intent goBack = new Intent(this, MainActivity.class);

        int musicIcon = R.mipmap.ic_library_music_black_24dp;
        int musicPlayIcon = R.mipmap.ic_play_arrow_black_24dp;

        ArrayList<Music> musics = new ArrayList<>();

        musics.add(new Music("Turn the Page", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("Ride the Lightning", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("Nothing Else Matters", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("Enter Sandman", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("The Unforgiven", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("Fade to Black", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("One", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("Sad but True", "Metallica", musicIcon, musicPlayIcon));
        musics.add(new Music("Wherever I may Roam", "Metallica", musicIcon, musicPlayIcon));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics);

        musicListView.setAdapter(musicAdapter);

        musicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast toast = Toast.makeText(MusicActivity.this, "Playing " + item, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MusicActivity.this, "Going back...", Toast.LENGTH_SHORT).show();
                goBack.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goBack);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}

