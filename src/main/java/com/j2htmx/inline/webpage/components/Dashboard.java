package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;

public class Dashboard extends NodeCreator {
    public Dashboard() {
        setTag("div");
        setContent(recentlyPlayed(), recommendation(), playlist(), separator(), player());
    }

    private NodeCreator recentlyPlayed() {
        return new Recent();
    }

    private NodeCreator separator() {
        Div separator = new Div();
        separator.setClass("separator-gradient");
        return separator;
    }

    private NodeCreator recommendation() {
        return new Recommendation();
    }

    private NodeCreator playlist() {
        return new Playlist();
    }

    private NodeCreator player() {
        Player bar = new Player();
        Div container= new Div();
        container.setContent(bar);
        container.setId("bar-player-full");
        bar.addClass("fade-content");
        return container;
    }
}
