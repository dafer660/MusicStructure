package com.example.danie.musicstructure;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class FavoritesActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ImageView backButton = findViewById(R.id.favorites_backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(FavoritesActivity.this, "Going back...", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
