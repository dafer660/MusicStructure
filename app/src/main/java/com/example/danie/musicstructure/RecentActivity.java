package com.example.danie.musicstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class RecentActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);

        ImageView backButton = findViewById(R.id.recent_backButton);
        final Intent goBack = new Intent(this, MainActivity.class);


        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(RecentActivity.this, "Going back...", Toast.LENGTH_SHORT);
                toast.show();
                goBack.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goBack);
            }
        });
    }
}
