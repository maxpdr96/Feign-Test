package com.hidarisoft.animeMX.service;


import com.hidarisoft.animeMX.model.*;
import com.hidarisoft.animeMX.service.feign.AnimeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AnimeService {

    @Autowired
    private AnimeFeign animeFeign;


    public ResponseEntity<ReturnAllAnime> retornaAllAnimes(String pathName) {

        ReturnAllAnime returnAllAnime = new ReturnAllAnime();

        ResponseEntity<SearchRoot> searchAnime = searchAnime(pathName);
        ResponseEntity<AllEpisodeRoot> allEpisode = AllEpisodesAnime(Objects.requireNonNull(searchAnime.getBody()).getResults().get(0).getMal_id());


        returnAllAnime.setSearchRoot(searchAnime.getBody());
        returnAllAnime.setAllEpisodeRoot(allEpisode.getBody());

        return ResponseEntity.ok(returnAllAnime);
    }

    public ResponseEntity<SearchRoot> searchAnime(String pathName) {

        SearchRoot searchRoot = searchAnimeFeign(pathName).getBody();

        assert searchRoot != null;
        for (SearchResult item : searchRoot.getResults()) {
            System.out.println(item.getMal_id());
            System.out.println(item.getTitle());
            System.out.println(item.getEpisodes());
            System.out.println("##############################");
        }

        return searchAnimeFeign(pathName);
    }

    public ResponseEntity<AllEpisodeRoot> AllEpisodesAnime(String pathName) {

        AllEpisodeRoot allEpisodeRoot = searchAllAnimeFeign(pathName).getBody();

        assert allEpisodeRoot != null;
        for (AllEpisodeResult item : allEpisodeRoot.getEpisodes()) {
            System.out.println(item.getEpisode_id());
            System.out.println(item.getTitle());
            System.out.println(item.getVideo_url());
            System.out.println("##############################");
        }

        return searchAllAnimeFeign(pathName);
    }

    public ResponseEntity<SearchRoot> searchAnimeFeign(String pathName) {
        System.out.println("TESTE SEARCH ANIME FEIGN");
        return animeFeign.searchAnimeFeign(pathName);
    }

    public ResponseEntity<AllEpisodeRoot> searchAllAnimeFeign(String pathName) {

        return animeFeign.AllEpisodeAnimeFeign(pathName);
    }

}
