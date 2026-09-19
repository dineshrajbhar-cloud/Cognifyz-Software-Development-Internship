package com.cognifyz.task6_web_scraping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrapingResponse {

    private String website;
    private int totalLinks;
    private List<ScrapedItem> links;

}
