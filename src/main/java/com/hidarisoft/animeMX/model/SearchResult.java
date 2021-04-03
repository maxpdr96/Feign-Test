package com.hidarisoft.animeMX.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {
    public String mal_id;
    public String url;
    public String image_url;
    public String title;
    public String airing;
    public String synopsis;
    public String type;
    public String episodes;
    public String score;
    public String start_date;
    public String end_date;
    public String members;
    public String rated;
}
