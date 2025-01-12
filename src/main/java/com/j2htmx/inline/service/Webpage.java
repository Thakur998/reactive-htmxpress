package com.j2htmx.inline.service;

import com.j2htmx.inline.html.canvas.WebpageHandler;
import com.j2htmx.inline.html.standard.form.Div;
import com.j2htmx.inline.html.standard.text.Paragraph;
import com.j2htmx.inline.repository.*;
import com.j2htmx.inline.webpage.Home;
import com.j2htmx.inline.webpage.components.Player;
import com.j2htmx.inline.webpage.components.Recommendation;
import com.j2htmx.inline.webpage.components.SearchBar;
import reactor.core.publisher.Flux;

public class Webpage extends WebpageHandler {

    RecentSongsRepository recentSongsRepository = new RecentSongsRepository();
    RecommendationSongsRepository recommendationSongsRepository = new RecommendationSongsRepository();
    SearchSongsRepository searchSongsRepository = new SearchSongsRepository();
    PlaylistRepository playlistRepository = new PlaylistRepository();
    PlayerRepository playerRepository = new PlayerRepository();
    FullScreenPlayerRepository fullScreenPlayerRepository = new FullScreenPlayerRepository(playerRepository);

    public Flux<String> createHome(String clientId) {
        Home home = new Home();
        add(home);
        return subscribeToFlux(clientId);
    }

    public Flux<String> getRecentSongs() {
        return Flux.just(recentSongsRepository.getRecentSongs());
    }

    public Flux<String> getRecommendationSongs() {
        return Flux.just(recommendationSongsRepository.getRecommendation());
    }

    public Flux<String> getSearchedSongs(String search) {
        return Flux.just(searchSongsRepository.getSearchedSongs(search));
    }

    public Flux<String> getPlaylist() {
        return Flux.just(playlistRepository.getRecentPlaylist());
    }

    public Flux<String> getFullScreen() {
        playerRepository.toggleFullscreen();
        return Flux.just(fullScreenPlayerRepository.getFullPlayer());
    }

    public Flux<String> getExpandedSearch() {
        return Flux.just(new SearchBar().createPairNode());
    }

    public Flux<String> toggleMusic(String link, String song) {
        String response = playerRepository.getButton(link, song);
        System.out.println(response);
        return Flux.just(response);
    }

    public Flux<String> toggleMusic(String link, String song, boolean card) {
        String response = playerRepository.getButton(link, song);
        System.out.println(response);
        return Flux.just(response);
    }

    public Flux<String> logUpdate() {
        //Log updates to all repository
        return  Flux.just(playerRepository.getCurrentSongInfo());
    }


    public Flux<String> barUpdate() {
        return Flux.just(playerRepository.getLastBarStatus());
    }

    public Flux<String> togglePlayerRepositoryEmpty() {
        playerRepository.toggleFullscreen();
        Div empty = new Div();
        empty.setHxTrigger("'load'");
        empty.setHxGet("/bar-update");
        empty.setHxTarget("#bar-player-full");
        return Flux.just(empty.createPairNode());
    }
}
