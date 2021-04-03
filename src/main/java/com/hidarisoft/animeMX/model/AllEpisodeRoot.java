package com.hidarisoft.animeMX.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllEpisodeRoot {
    public String request_hash;
    public String request_cached;
    public String request_cache_expiry;
    public String episodes_last_page;
    public List<AllEpisodeResult> episodes;
}
