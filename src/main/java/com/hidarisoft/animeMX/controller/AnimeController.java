package com.hidarisoft.animeMX.controller;


import com.hidarisoft.animeMX.model.AllEpisodeRoot;
import com.hidarisoft.animeMX.model.ReturnAllAnime;
import com.hidarisoft.animeMX.model.SearchRoot;
import com.hidarisoft.animeMX.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping(value = "/animeSearch/{pathName}")
    private ResponseEntity<SearchRoot> searchAnimeController(@PathVariable("pathName") String pathName){
        return animeService.searchAnimeFeign(pathName);
    }

    @GetMapping(value = "/episodeSearch/{pathName}")
    private ResponseEntity<AllEpisodeRoot> searchEpisodeAnimeController(@PathVariable("pathName") String pathName){
        return animeService.AllEpisodesAnime(pathName);
    }

    @GetMapping(value = "/retornall/{pathName}")
    private ResponseEntity<ReturnAllAnime> retornaAllController(@PathVariable("pathName") String pathName){
        return animeService.retornaAllAnimes(pathName);
    }

}
