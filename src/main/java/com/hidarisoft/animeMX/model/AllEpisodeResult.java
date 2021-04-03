package com.hidarisoft.animeMX.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllEpisodeResult {
    public String episode_id;
    public String title;
    public String title_japanese;
    public String title_romanji;
    public String aired;
    public String filler;
    public String recap;
    public String video_url;
    public String forum_url;
}
