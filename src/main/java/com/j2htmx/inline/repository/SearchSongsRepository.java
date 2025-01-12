package com.j2htmx.inline.repository;

import com.j2htmx.inline.beans.Song;
import com.j2htmx.inline.html.nodes.NodeCreator;
import com.j2htmx.inline.html.standard.table.Table;
import com.j2htmx.inline.utils.FileLoader;
import com.j2htmx.inline.webpage.components.SearchResult;
import com.j2htmx.inline.webpage.components.SearchTable;

import java.util.*;


public class SearchSongsRepository {

    private final String EMPTY_SEARCH = "";


    public String getSearchedSongs(String search) {
        //Validations
        if (search == null || search.length() <= 0) {
            return EMPTY_SEARCH;
        }

        return searchSong(search).createPairNode();
    }



    public Map<String, Song> searchByPrefix(Map<String, Song> map, String prefix) {
        Map<String, Song> result = new HashMap<>();

        // Iterate over the map entries
        for (Map.Entry<String, Song> entry : map.entrySet()) {
            if (entry.getKey().toUpperCase().startsWith(prefix.toUpperCase())) {
                result.put(entry.getKey(), entry.getValue()); // Add to result if key starts with the prefix
            }
        }

        return result; // Return map with matching entries
    }

    private NodeCreator searchSong(String song) {
        Table songs = new SearchTable();
        SearchResult searchResult = new SearchResult();
        for (Map.Entry<String,Song> entry : searchByPrefix(FileLoader.songsFound, song).entrySet()) {
            Song found = entry.getValue();
            songs.addData(searchResult.getResultAsList(entry.getKey(), found.getSinger(), found.getLink(), found.getAlbum()));
        }
        return songs;
    }


}
