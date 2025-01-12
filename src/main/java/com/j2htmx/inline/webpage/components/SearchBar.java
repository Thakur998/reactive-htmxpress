package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.form.Form;
import com.j2htmx.inline.html.standard.form.InputBox;
import com.j2htmx.inline.html.standard.text.Heading;

public class SearchBar extends NodeCreator {
    public SearchBar() {
        setTag("div");
        setContent(getSearchBar().concat(getSearchArea()));
    }

    private String getSearchArea() {
        Div searchArea = new Div();
        searchArea.setClass("fade-content");
        searchArea.setId("search-area");
        return searchArea.createPairNode();
    }


    private String getSearchBar() {

        Form searchForm = new Form();

        InputBox inputBox = new InputBox();
        inputBox.setType("text");
        inputBox.setClass("search-bar");
        Heading heading = new Heading();
        heading.createPairNode();
        inputBox.setPlaceholder("' Search song'");
        inputBox.setHxTrigger("'keyup delay:500ms changed'");
        inputBox.setHxTarget("#search-area");
        inputBox.setHxGet("/search");
        inputBox.setId("search-item");
        inputBox.setName("search-item");

        searchForm.setContent(inputBox.createPairNode());
        return searchForm.createPairNode();
    }


}
