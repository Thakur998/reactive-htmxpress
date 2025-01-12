package com.j2htmx.inline.repository;

import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.webpage.components.PlayerExtended;

public class FullScreenPlayerRepository {
    PlayerExtended full;
    public FullScreenPlayerRepository(PlayerRepository playerRepository) {
        full = new PlayerExtended("TEst","Playing Song", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREnIlz0ToaDYtFCIGcgBzdnshsEAdx5RPb3Q&s");
    }

    public String getFullPlayer() {
        Div removeMediaBar = new Div();
        removeMediaBar.setHxTarget("#bar-player-full");
        removeMediaBar.setHxTrigger("'load'");
        removeMediaBar.setHxGet("/empty");
        return full.createPairNode().concat(removeMediaBar.createPairNode());
    }
}
