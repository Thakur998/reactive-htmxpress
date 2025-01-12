package com.j2htmx.inline.repository;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.webpage.components.Card;

public class PlaylistRepository {

    Div playlist = new Div();
    boolean isFullscreen = false;
    public PlaylistRepository() {
        Card inTheEnd = new Card("Happy songs", "", "https://external-preview.redd.it/the-mood-of-this-playlist-is-heavy-introspective-and-v0-j97dj24qhCOttqimD3KAJpoRvFAi39DypL_8lVEVJY4.jpg?auto=webp&s=02c3aa6c7460bdeed18c2c3a5bf3c2b022b6da2e");

        playlist.setContent(inTheEnd, inTheEnd, inTheEnd, inTheEnd);
        playlist.setClass("scroll-container");

    }

    public String getRecentPlaylist() {
        Div recentSongs = new Div();
        recentSongs.setContent(getRecent());
        return recentSongs.createPairNode();
    }

    private NodeCreator getRecent() {
        return this.playlist;
    }

    public void toggleFullScreen() {
        isFullscreen = !isFullscreen;
    }
}
