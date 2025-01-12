package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Button;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.link.SVG;

public class PlayerExtended extends NodeCreator {
    Div cardContent = new Div();
    public PlayerExtended() {
        setTag("div");
        setClass("card-full");
    }

    public PlayerExtended(String title, String subtitle, String background) {
        Button close = new Button();
        close.setHxTarget("#search-area");
        close.setHxGet("/empty-toggle");
        close.setClass("close-button card-full-subtitle");
        close.setContent("go back");

        cardContent.setClass("card-full-content");


        setClass("card-full");
        setBackgroundImage(background);
        cardContent.setContent(close,setCardTitle(title),setCardSubtitle(subtitle));
        setContent(cardContent);
        setTag("div");
    }

    public PlayerExtended(String title, String subtitle, SVG background) {
        Button close = new Button();
        close.setHxTarget("#search-area");
        close.setHxGet("/empty");
        close.setClass("close-button card-full-subtitle");
        close.setContent("back");

        cardContent.setClass("card-full-content");
        setClass("card-full");
        background.setClass("card-full-media");
        cardContent.setContent(close, setCardTitle(title),setCardSubtitle(subtitle));
        setContent(background,cardContent);
        setTag("div");

//        Div observe = new Div();
//        observe.setHxTrigger("'every 2s'");
//        observe.setHxGet("/bar-update");
//        observe.setHxTarget("#bar-player-full");
//        fullscreen.setId("full-screen-player");

    }

    public void initCard(String title, String subtitle, String background) {
        setBackgroundImage(background);
        setContent(setCardTitle(title),setCardSubtitle(subtitle));
    }

    private NodeCreator setCardTitle(String title) {
        Div cardTitle = new Div();
        cardTitle.setClass("card-full-title");
        cardTitle.setContent(title);
        return cardTitle;
    }

    private NodeCreator setCardSubtitle(String subtitle) {
        Div cardSubTitle = new Div();
        cardSubTitle.setClass("card-full-subtitle");
        cardSubTitle.setContent(subtitle);
        return cardSubTitle;
    }

    private void setBackgroundImage(String backgroundImage) {
        setStyleViaString(String.format("style=\"background-image: url('%s');\"", backgroundImage));
    }

}
