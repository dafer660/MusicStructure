package com.example.danie.musicstructure;

public class Music{

    //declare private data instead of public to ensure the privacy of data field of each class
    private String musicName;
    private String musicArtist;
    private int musicImageID;
    private int musicPlayID;

    public Music(String musicName, String musicArtist, int musicImageID, int musicPlayID) {
        this.musicName = musicName;
        this.musicArtist = musicArtist;
        this.musicImageID = musicImageID;
        this.musicPlayID = musicPlayID;

    }

    public String getMusicName(){
        return musicName;
    }

    public String getMusicArtist(){
        return musicArtist;
    }

    public int getMusicImageID(){
        return musicImageID;
    }

    public int getMusicPlayID(){
        return musicPlayID;
    }

}
