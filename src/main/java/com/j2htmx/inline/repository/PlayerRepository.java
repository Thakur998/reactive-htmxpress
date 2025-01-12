package com.j2htmx.inline.repository;

import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.form.Button;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.form.Option;
import com.j2htmx.inline.webpage.components.Player;

import java.util.Optional;

public class PlayerRepository {
    Button playButton;
    Button pauseButton;
    boolean isFullScreen;
    Button status;
    String song;
    String link;
    //Need to create counter how many player at same time
    //to do cool stuff
    Player player = new Player();

    public PlayerRepository() {
        player.setId("bar-player-full");
    }

    boolean play = true;


    public String getButton(String link, String song) {
        if(!song.equals(this.song)){
            playButton = null;
        }
        this.song = song;
        NodeCreator audio = new NodeCreator();
        audio.setSource(link);
        audio.setTag("audio");
        audio.setType("audio/mpeg");
        audio.setName("song-player");
        audio.setId("music-player");

        if (playButton==null) {
            playButton = player.playButton(link, song);
            pauseButton = player.pauseButton(link, song);
            this.link = link;
            play = false;
            audio.setMisc("oncanplay = 'playMusic()'");
            return pauseButton.createPairNode().concat(audio.createPairNode());
        }

        if (play) {
            play = false;
            audio.setMisc("oncanplay = 'playMusic()'");
            return pauseButton.createPairNode().concat(audio.createPairNode());
        } else  {
            play = true;
            audio.setMisc("oncanplay = 'pauseMusic()'");
            return playButton.createPairNode().concat(audio.createPairNode());
        }

    }

    public String getPlayer() {
        return player.createPairNode();
    }

    public Player getPlayerNode() {
        return player;
    }

    public String getCurrentSongInfo() {
        if (isFullScreen) {
            return new Div().createPairNode();
        }
        if (!play) {
            status = playButton;
            return new Player(status).getSongInfo("Playing", song).createPairNode();
        } else {
            if (pauseButton == null) {
                String playing = Optional.ofNullable(song).orElse("back");
                return player.getSongInfo("Welcome", playing).createPairNode();
            }
            status = pauseButton;
            return new Player(status).getSongInfo("Paused", song).createPairNode();
        }
    }

    public void toggleFullscreen() {
        isFullScreen = !isFullScreen;
    }

    public String getLastBarStatus() {
        if (isFullScreen) {
            return "";
        } else {
            return getPlayer();
        }
    }
}
