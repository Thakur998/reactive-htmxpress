package com.j2htmx.inline.webpage.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Button;
import com.j2htmx.inline.html.standard.form.Label;

import java.util.List;
import java.util.Map;

public class SearchResult extends NodeCreator {
    public SearchResult() {
        setTag("div");
    }

    public List<String> getResultAsList(String song, String artist, String link, String album) {
        Button songTitle = new Button();
        songTitle.setClass("song-title");
        songTitle.setContent(song);
        songTitle.setOnclick("'playMusic()'");
        songTitle.setHxTarget("#state");
        Map<String, String> songName = Map.of("song-link", link, "song", song);
        songTitle.setHxGet("/toggle");
        try {
            songTitle.setHxVals(new ObjectMapper().writeValueAsString(songName));
            songTitle.setHxOn("'playMusic()'");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Label songArtist = new Label();
        songArtist.setClass("song-artist");
        songArtist.setContent(artist);


        return List.of(songTitle.createPairNode(),songArtist.createPairNode());
    }
}
