package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.text.Heading;

public class Recommendation extends NodeCreator {
    public Recommendation() {
        setTag("div");
        setId("recommendation");
        setContent(getHeading(),getSongs());
    }

    private NodeCreator getHeading() {
        Heading title = new Heading("h1");
        title.setContent("Recommendation");
        title.setClass("clickable text-soft");
        return new ToggleWithExpand(title, "recommendation-see-all");
    }


    private NodeCreator getSongs() {
        Div div = new Div();
        div.setHxTrigger("'load'");
        div.setId("recommendation-songs");
        div.setHxGet("/get-recommendation");
        return div;
    }
}