package com.j2htmx.inline.repository;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.webpage.components.Card;

public class RecommendationSongsRepository {

    Div recommendation = new Div();

    public RecommendationSongsRepository() {
        Card danDaDan = new Card("Dan Da Dan", "Creepy Nuts", "https://img.amiami.com/images/product/main/243/CARD-00027687.jpg");

        recommendation.setContent(danDaDan,danDaDan,danDaDan);
        recommendation.setClass("scroll-container");

    }

    private NodeCreator getRecent() {
        return this.recommendation;
    }


    public String getRecommendation() {
        Div songs = new Div();
        songs.setContent(getRecent());
        return songs.createPairNode();
    }
}
