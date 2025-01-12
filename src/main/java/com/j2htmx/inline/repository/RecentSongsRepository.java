package com.j2htmx.inline.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2htmx.inline.beans.Song;
import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.utils.FileLoader;
import com.j2htmx.inline.webpage.components.Card;

import java.util.Map;

public class RecentSongsRepository {

    Div recent = new Div();

    public RecentSongsRepository() {
        Card inTheEnd = new Card("In The End", "Linkin park", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRVAXlrBZd0qD2YRRSal6802TtSFVo38Z-Uw&s");
        for (Map.Entry<String, Song> song : FileLoader.songsFound.entrySet()) {
            Song current = song.getValue();
            Card songTitle= new Card(current.getSong(), current.getSinger(), current.getAlbum());
            songTitle.setHxTrigger("click");
            songTitle.setHxTarget("#state");
            Map<String, String> songName = Map.of("song-link", current.getLink(), "song", current.getSong());
            songTitle.setHxGet("/toggle");
            try {
                songTitle.setHxVals(new ObjectMapper().writeValueAsString(songName));
                songTitle.setHxOn("'playMusic()'");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            recent.addContent(songTitle);
        }
        recent.setClass("scroll-container");

    }

    public String getRecentSongs() {
        Div recentSongs = new Div();
        recentSongs.setContent(getRecent());
        return recentSongs.createPairNode();
    }

    private NodeCreator getRecent() {
        return this.recent;
    }
}
