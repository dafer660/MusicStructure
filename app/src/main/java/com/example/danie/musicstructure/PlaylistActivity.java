package com.example.danie.musicstructure;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaylistActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_list);

        ListView PlaylistListView = findViewById(R.id.p_list);
        ImageView playlist_backButton = findViewById(R.id.playlist_backButton);

        int playlistIcon = R.mipmap.ic_play_arrow_black_24dp;

        ArrayList<Playlist> playlists = new ArrayList<>();

        playlists.add(new Playlist("Metallica", 5, playlistIcon));
        playlists.add(new Playlist("Rage Against the Machine", 10, playlistIcon));

        PlaylistAdapter playlistAdapter = new PlaylistAdapter(this, playlists);

        PlaylistListView.setAdapter(playlistAdapter);

        PlaylistListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(PlaylistActivity.this, "Playing... " + item, Toast.LENGTH_SHORT).show();
            }
        });

        playlist_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlaylistActivity.this, "Going back...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
