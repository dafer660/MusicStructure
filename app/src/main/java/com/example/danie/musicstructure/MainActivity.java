package com.example.danie.musicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView favoritesIcon = findViewById(R.id.favoriteIcon);
        ImageView playIcon = findViewById(R.id.playIcon);
        ImageView fastForwardIcon = findViewById(R.id.fastForwardIcon);

        favoritesIcon.setOnClickListener(this);
        playIcon.setOnClickListener(this);
        fastForwardIcon.setOnClickListener(this);

        LinearLayout library = findViewById(R.id.library_layout);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        LinearLayout favorites = findViewById(R.id.favorites_layout);
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        LinearLayout recent = findViewById(R.id.recent_layout);
        recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecentActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        LinearLayout playlist = findViewById(R.id.playlist_layout);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        // old way -> onClick added below with switch()
//        favoritesIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(MainActivity.this, "Saved to favorites...", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){

            case R.id.favoriteIcon:

                // by clicking the favorites button this will be added to the favorites
                final Intent saveToFavorites = new Intent(this, FavoritesActivity.class);
                saveToFavorites.putExtra("song", "One");
                saveToFavorites.putExtra("artist", "Metallica");
                startActivity(saveToFavorites);

                Toast.makeText(getBaseContext(), "Saved to favorites...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.playIcon:
                Toast.makeText(getBaseContext(), "Playing track...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.fastForwardIcon:
                Toast.makeText(getBaseContext(), "Playing next track...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
