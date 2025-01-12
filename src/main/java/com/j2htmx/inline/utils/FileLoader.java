package com.j2htmx.inline.utils;

import com.j2htmx.inline.beans.Song;
import com.j2htmx.inline.html.custom.processor.CSSLoader;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileLoader {

    public static final Map<String, Song> songsFound = files();

    private static Map<String, Song> files() {
        CSSLoader songsList = new CSSLoader();
        CSSLoader link = new CSSLoader();
        CSSLoader album = new CSSLoader();
        CSSLoader singer = new CSSLoader();

        String songs = "";

        Map<String, Song> foundSongs = new TreeMap<>();
        try {
            songsList.load("song-list");
            album.load("song-album");
            link.load("song-link");
            singer.load("song-singer");
            songs = songsList.getProperty("list");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] arr = songs.split(" ");

        for (String song : arr) {
            foundSongs.put(song, new Song(song,album.getProperty(song),link.getProperty(song),singer.getProperty(song)));
        }


        return foundSongs;

    }
}
