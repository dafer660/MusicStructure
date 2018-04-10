package com.example.danie.musicstructure;

public class Playlist {

    //declare private data instead of public to ensure the privacy of data field of each class
    private String playlistName;
    private int playlistTotalMusics;
    private int playlistPlayID;

    public Playlist(String playlistName, int playlistTotalMusics, int playlistPlayID) {
        this.playlistName = playlistName;
        this.playlistTotalMusics = playlistTotalMusics;
        this.playlistPlayID = playlistPlayID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public int getPlaylistTotalMusics() {
        return playlistTotalMusics;
    }

    public int getPlaylistPlayID() {
        return playlistPlayID;
    }
}
