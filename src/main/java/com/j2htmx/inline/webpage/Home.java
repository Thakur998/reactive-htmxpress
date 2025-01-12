package com.j2htmx.inline.webpage;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.webpage.components.MainFeed;
import com.j2htmx.inline.webpage.components.SearchBar;

public class Home extends NodeCreator {

    public Home() {
        setTag("div");
        setId("parent-div");
        setClass("container content-wrap");
        setContent(getSearchBar(),getMainFeed());

    }

    private NodeCreator getSearchBar() {
        return new SearchBar();
    }

    private NodeCreator getMainFeed() {
        return new MainFeed();
    }



}
