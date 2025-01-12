package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;

//Note to future self : this is placeholder for Dashboard and Player
public class MainFeed extends NodeCreator {
    public MainFeed() {
        setTag("div");
        setId("main-feed");
        setContent(new Dashboard());
    }
}
