package com.j2htmx.inline.webpage.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Button;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.form.InputBox;
import com.j2htmx.inline.html.standard.table.Table;

import java.util.List;
import java.util.Map;


public class Player extends NodeCreator {

    public Player(Button status) {
        setTag("div");
        setClass("media-bar");
        Div player = new Div();
        player.setClass("media-container");
        player.setContent(getControls(status));
        setContent(player);
    }

    public Player() {
        setTag("div");
        setClass("footer media-bar");
        Div player = new Div();
        player.setClass("media-container");
        player.setContent(getControls());
        setContent(player);
    }

    /*
     <div class="controls">
        <button class="control-button">
        </button>
        <button class="control-button play-button">
        </button>
        <button class="control-button">
        </button>
      </div>
     */

    public Button playButton(String link, String song ){
        Button play = new Button();
        play.setClass("control-button play-button");
        play.setContent("PLAY");
        play.setHxGet("/toggle");
        play.setOnclick("\"playMusic()\"");
        play.setHxTarget("#state");
        play.setHxSwap("innerHTML");
        play.setHxTrigger("'click consume'");
        play.setId("song-link-button");
        play.setName(link);
        Map<String, String> songMeta = Map.of("song-link", link, "song", song);

        try {
            play.setHxVals(new ObjectMapper().writeValueAsString(songMeta));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return play;
    }


    public Button pauseButton(String link, String song) {
        Button pause = new Button();
        pause.setClass("control-button play-button");
        pause.setContent("PAUSE");
        pause.setHxGet("/toggle");
        pause.setHxTarget("#state");
        pause.setHxSwap("innerHTML");
        pause.setOnclick("\"pauseMusic()\"");
        pause.setId("song-link-button");
        pause.setName(link);
        Map<String, String> songMeta = Map.of("song-link", link, "song", song);

        try {
            pause.setHxVals(new ObjectMapper().writeValueAsString(songMeta));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return pause;
    }

    public NodeCreator getControls(Button status) {
        Div controls = new Div();
        controls.setClass("controls");
        Button back = new Button();
        back.setContent("&#10094;");
        back.setClass("control-button");

        Button forward = new Button();
        forward.setClass("control-button");
        forward.setContent("&#10095;");


        InputBox slider = new InputBox();

        slider.setType("range");
        slider.setClass("slider control-button");

        Div contain = new Div();
        contain.setId("state");
        contain.setContent(status);
        controls.setContent(back,contain,forward);
        controls.addContent(slider.createNode());
        return controls;
    }

    public NodeCreator getControls() {
        Div controls = new Div();
        controls.setClass("controls");
        Button back = new Button();
        back.setContent("&#10094;");
        back.setClass("control-button");

        Button forward = new Button();
        forward.setClass("control-button");
        forward.setContent("&#10095;");

        InputBox slider = new InputBox();

        slider.setType("range");
        slider.setClass("slider control-button");

        slider.setId("player-slider");
        Div contain = new Div();
        contain.setId("state");
        contain.setContent(playButton("", ""));
        controls.setContent(back,contain,forward);
        controls.addContent(slider.createNode());
        return controls;
    }


    public NodeCreator getSongInfo(String songTitle, String artistName) {
        Table info = new Table();
        info.setClass("song-info");
        Div title = new Div();
        title.setContent(songTitle);
        title.setClass("song-title clickable");
        Div artist = new Div();
        title.setHxTarget("#search-area");
        title.setHxGet("/full-screen-player");


        artist.setClass("song-artist");


        info.addData(List.of(title.createPairNode(),artist.createPairNode()));

        return info;
    }



}
