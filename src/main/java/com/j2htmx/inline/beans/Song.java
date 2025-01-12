package com.j2htmx.inline.beans;


public class Song {
    private String song;
    private String album;
    private String link;
    private String singer;

    public Song(String song, String album, String link, String singer) {
        this.singer = singer;
        this.song = song;
        this.link = link;
        this.album = album;
    }

    public String getSinger() {
        return this.singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public String getLink() {
        return link;
    }
}
