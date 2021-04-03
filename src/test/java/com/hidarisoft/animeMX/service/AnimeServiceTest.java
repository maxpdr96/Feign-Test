package com.hidarisoft.animeMX.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hidarisoft.animeMX.model.SearchResult;
import com.hidarisoft.animeMX.model.SearchRoot;
import com.hidarisoft.animeMX.service.feign.AnimeFeign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class AnimeServiceTest {

    @InjectMocks
    private AnimeService animeService;

    @Mock
    private AnimeFeign animeFeign;

    @Mock
    private SearchRoot searchRoot;

    @Mock
    private SearchResult searchResult;


    @Test
    public void retornaAllAnimes() {
    }

    @Test
    public void searchAnime() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SearchRoot searchRootValue = objectMapper.readValue(
                new File("src/test/java/com/hidarisoft/animeMX/jsons/responseRight.json"), SearchRoot.class);
        ResponseEntity<SearchRoot> searchRootFeign = new ResponseEntity<SearchRoot>(searchRootValue, HttpStatus.OK);
        SearchRoot searchRootExpected = objectMapper.readValue(
                new File("src/test/java/com/hidarisoft/animeMX/jsons/responseTest.json"), SearchRoot.class);

        when(animeService.searchAnimeFeign(Mockito.anyString())).thenReturn(searchRootFeign);

        SearchRoot searchRoot = animeService.searchAnime("gintama").getBody();


        assertEquals(searchRootExpected, searchRoot);

    }

    @Test
    public void allEpisodesAnime() {
    }

    @Test
    public void searchAnimeFeign() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SearchRoot searchRootValue = objectMapper.readValue(
                new File("src/test/java/com/hidarisoft/animeMX/jsons/responseRight.json"), SearchRoot.class);
        ResponseEntity<SearchRoot> searchRootFeign = new ResponseEntity<SearchRoot>(searchRootValue, HttpStatus.OK);
        SearchRoot searchRootExpected = objectMapper.readValue(
                new File("src/test/java/com/hidarisoft/animeMX/jsons/responseTest.json"), SearchRoot.class);

        when(animeFeign.searchAnimeFeign(Mockito.anyString())).thenReturn(searchRootFeign);

        SearchRoot searchRoot = animeService.searchAnimeFeign("gintama").getBody();


        assertEquals(searchRootExpected, searchRoot);
    }

    @Test
    public void searchAllAnimeFeign() {
    }

}