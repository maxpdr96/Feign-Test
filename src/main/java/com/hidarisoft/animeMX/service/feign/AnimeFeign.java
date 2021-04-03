package com.hidarisoft.animeMX.service.feign;


import com.hidarisoft.animeMX.config.SSLSocketClient;
import com.hidarisoft.animeMX.model.AllEpisodeRoot;
import com.hidarisoft.animeMX.model.SearchRoot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feignAnimeClient", url = "${url.feign.jikan}", configuration = SSLSocketClient.class)
public interface AnimeFeign {

    @GetMapping(value = "/search/anime?q={pathName}")
    ResponseEntity<SearchRoot> searchAnimeFeign(@PathVariable("pathName") String pathName);

    @GetMapping(value = "/anime/{pathName}/episodes")
    ResponseEntity<AllEpisodeRoot> AllEpisodeAnimeFeign(@PathVariable("pathName") String pathName);
}
