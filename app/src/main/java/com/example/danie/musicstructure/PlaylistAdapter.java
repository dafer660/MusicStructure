package com.example.danie.musicstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(@NonNull Context context, ArrayList<Playlist> playlist) {
        super(context, 0, playlist);
    }

    @Override
    public View getView(int position, @Nullable View convertView, final ViewGroup parent) {
        // Get the data item for this position
        Playlist playlist = getItem(position);

        View ListView = convertView;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.playlist_textviews, parent, false);
        }

        TextView pName = convertView.findViewById(R.id.playlistName);
        TextView pTotal = convertView.findViewById(R.id.playlistTotal);
        ImageView pPlay = convertView.findViewById(R.id.playlistIcon);

        pName.setText(playlist.getPlaylistName());
        pTotal.setText(String.format("%s tracks", String.valueOf(playlist.getPlaylistTotalMusics())));
        pPlay.setImageResource(playlist.getPlaylistPlayID());

        return convertView;
    }
}
