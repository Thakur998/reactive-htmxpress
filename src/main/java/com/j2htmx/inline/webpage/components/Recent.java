package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.text.Heading;

public class Recent extends NodeCreator {
    public Recent() {
        setTag("div");
        setId("recent");
        setContent(miniPlay(), getSearchDivBefore(),separator(),getHeading(),getSongs());
    }

    private NodeCreator miniPlay() {
        Div player = new Div();

        player.setClass("fade-content");
        Div toggle = new Div();
        toggle.setHxTrigger("'every 1.5s'");
        toggle.setHxTarget("#player-screen");
        toggle.setHxGet("/now-playing");

        Div miniPLay = new Div();
        miniPLay.setClass("fade-content");
        miniPLay.setId("player-screen");;

        player.setContent(toggle, miniPLay);

        return player;
    }

    private Div getSearchDivBefore() {
        Div searchArea = new Div();
        searchArea.setClass("fade-content");
        searchArea.setId("search-div-before");
        return searchArea;
    }

    private NodeCreator getHeading() {
        Heading title = new Heading("h1");
        title.setContent("Recent");
        title.setClass("clickable text-soft");
        return new ToggleWithExpand(title, "recent-played-see-all");
    }



    private NodeCreator separator() {
        Div separator = new Div();
        separator.setClass("separator-gradient");
        return separator;
    }


    private NodeCreator getSongs() {
        Div div = new Div();
        div.setHxTrigger("'load'");
        div.setId("recent-songs");
        div.setHxGet("/get-recent-songs");
        return div;
    }
}
