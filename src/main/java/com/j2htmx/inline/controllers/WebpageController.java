package com.j2htmx.inline.controllers;

import com.j2htmx.inline.service.Webpage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
public class WebpageController {

    Webpage webpage = new Webpage();

    @GetMapping("/home")
    public Flux<String> home() {
        return webpage.createHome(UUID.randomUUID().toString());
    }

    @GetMapping("/get-recent-songs")
    public Flux<String> getRecentSongs() {
        return webpage.getRecentSongs();
    }

    @GetMapping("/get-recommendation")
    public Flux<String> getRecommedationSongs() {
        return webpage.getRecommendationSongs();
    }

    @GetMapping("/search")
    public Flux<String> getSearchedSongs(@RequestParam("search-item") String search) {
        return webpage.getSearchedSongs(search);
    }

    @GetMapping("/get-playlist")
    public Flux<String> getPlaylistSongs() {
        return webpage.getPlaylist();
    }

    @GetMapping("/full-screen-player")
    public Flux<String> getFullScreen() {
        return webpage.getFullScreen();
    }

    @GetMapping("/empty-toggle")
    public Flux<String> getEmptyToggle() {
        return webpage.togglePlayerRepositoryEmpty();
    }

    @GetMapping("/expand-search")
    public Flux<String> getSearch() {
        return webpage.getExpandedSearch();
    }

    @GetMapping("/toggle")
    public Flux<String> getPlay(@RequestParam("song-link") String link, @RequestParam("song") String song) {
        return webpage.toggleMusic(link, song);
    }

    @GetMapping("/card-play")
    public Flux<String> cardPlay(@RequestParam("song-link") String link, @RequestParam("song") String song) {
        return webpage.toggleMusic(link, song, true);
    }

    @GetMapping("/now-playing")
    public Flux<String> getPlay() {
        return webpage.logUpdate();
    }

    @GetMapping("/empty")
    public Flux<String> getEmpty() {
        return Flux.just("");
    }


    @GetMapping("/bar-update")
    public Flux<String> updateBar() {
        return webpage.barUpdate();
    }


}
