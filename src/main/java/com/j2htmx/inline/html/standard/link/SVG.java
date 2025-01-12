package com.j2htmx.inline.html.standard.link;

import com.j2htmx.inline.html.nodes.NodeCreator;

public class SVG extends NodeCreator {
    public SVG(String data) {
        setTag("div");
        setContentFromProperty(data);
    }
}
