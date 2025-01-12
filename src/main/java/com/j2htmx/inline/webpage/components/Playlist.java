package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.table.Table;
import com.j2htmx.inline.html.standard.text.Heading;

public class Playlist extends NodeCreator {
    public Playlist() {
        setTag("div");
        setId("playlist");
        setContent(getHeading(),getSongs());
    }

    private NodeCreator getHeading() {
        Heading title = new Heading("h1");
        title.setContent("Playlist");
        title.setClass("clickable text-soft");
        return new ToggleWithExpand(title, "playlist-see-all");
    }


    private NodeCreator getSongs() {
        Div div = new Div();
        div.setHxTrigger("'load'");
        div.setId("playlist-songs");
        div.setHxGet("/get-playlist");
        return div;
    }
}
