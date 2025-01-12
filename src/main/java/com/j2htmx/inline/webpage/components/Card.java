package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;

/*
 <div class="card" style="background-image: url('https://via.placeholder.com/400x250');">
        <div class="card-content">
            <div class="card-title">Card Title</div>
            <div class="card-subtitle">Card Subtitle</div>
        </div>
    </div>
 */
public class Card extends NodeCreator {

    Div cardContent = new Div();

    public Card() {
        cardContent.setClass("card-content");
        setClass("card");
        setTag("div");
    }

    public Card(String title, String subtitle, String background) {
        cardContent.setClass("card-content");
        setClass("card");
        setBackgroundImage(background);
        cardContent.setContent(setCardTitle(title),setCardSubtitle(subtitle));
        setContent(cardContent);
        setTag("div");
    }

    public void initCard(String title, String subtitle, String background) {
        setBackgroundImage(background);
        setContent(setCardTitle(title),setCardSubtitle(subtitle));
    }

    private NodeCreator setCardTitle(String title) {
        Div cardTitle = new Div();
        cardTitle.setClass("card-title");
        cardTitle.setContent(title);
        return cardTitle;
    }

    private NodeCreator setCardSubtitle(String subtitle) {
        Div cardSubTitle = new Div();
        cardSubTitle.setClass("card-subtitle");
        cardSubTitle.setContent(subtitle);
        return cardSubTitle;
    }

    private void setBackgroundImage(String backgroundImage) {
        setStyleViaString(String.format("style=\"background-image: url('%s');\"", backgroundImage));
    }

}
