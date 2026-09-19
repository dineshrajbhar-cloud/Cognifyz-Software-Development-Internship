package com.cognifyz.task6_web_scraping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrapedItem {

    private String title;
    private String link;

}
