package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.form.InputBox;
import com.j2htmx.inline.html.standard.form.Label;
import com.j2htmx.inline.html.standard.text.Heading;
import com.j2htmx.inline.html.standard.text.Paragraph;

import java.util.UUID;

/*
 <div class="toggle-container">
        <!-- Checkbox for toggling animation -->
        <input type="checkbox" id="toggle" class="toggle">
        <!-- Expandable content -->
        <div class="expandable-content">
            <h3>Additional Content</h3>
            <p>
                This is where the additional information will go. It expands with a smooth animation to reveal hidden content beneath the card. The design is responsive, elegant, and premium!
            </p>
        </div>
    </div>
 */

public class ToggleWithExpand extends NodeCreator {
    public ToggleWithExpand(NodeCreator toggle, String expandId) {
        String toggleId = UUID.randomUUID().toString();
        setTag("div");
        setClass("toggle-container");
        setContent(toggle(toggle, toggleId) + getToggleSetup(toggleId).concat(expandableContent(expandId).createPairNode()));

    }

    public ToggleWithExpand(NodeCreator toggle, String expandId, String toggleId) {
        setTag("div");
        setClass("toggle-container");
        setContent(toggle(toggle, toggleId) + getToggleSetup(toggleId).concat(expandableContent(expandId).createPairNode()));
    }

    private String toggle(NodeCreator nodeCreator, String id) {
        Label content = new Label();
        content.setForId(id);
        content.setContent(nodeCreator);
        return content.createPairNode();
    }


    private String getToggleSetup(String id) {
        InputBox inputBox = new InputBox();
        inputBox.setClass("toggle");
        inputBox.setType("checkbox");
        inputBox.setId(id);
        return inputBox.createPairNode();
    }

    private NodeCreator expandableContent(String id) {
        Div expand = new Div();
        expand.setClass("expandable-content");
        Heading heading = new Heading("h3");
        heading.setContent("");
        Paragraph content = new Paragraph();
        content.setId(id);
        content.setHxOutOfOrderSwap();
        expand.setContent(heading,content);
        return expand;
    }


}
