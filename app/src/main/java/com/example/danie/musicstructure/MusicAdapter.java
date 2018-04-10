package com.example.danie.musicstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music>{

    public MusicAdapter(@NonNull Context context, ArrayList<Music> music) {
        super(context, 0, music);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        // Get the data item for this position
        Music music = getItem(position);

        View ListView = convertView;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.music_textviews, parent, false);
        }

        TextView mName = convertView.findViewById(R.id.musicName);
        TextView mArtist = convertView.findViewById(R.id.musicArtist);
        ImageView mIcon = convertView.findViewById(R.id.musicIcon);
        ImageView mPlay = convertView.findViewById(R.id.musicPlayIcon);

        mName.setText(music.getMusicName());
        mArtist.setText(music.getMusicArtist());
        mIcon.setImageResource(music.getMusicImageID());
        mPlay.setImageResource(music.getMusicPlayID());

        return convertView;
    }
}
