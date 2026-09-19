package com.cognifyz.task6_web_scraping.controller;

import com.cognifyz.task6_web_scraping.model.ScrapedItem;
import com.cognifyz.task6_web_scraping.model.ScrapingResponse;
import com.cognifyz.task6_web_scraping.service.WebScraperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/scraper")
public class WebScraperController {

    private final WebScraperService webScraperService;

    public WebScraperController(WebScraperService webScraperService) {
        this.webScraperService = webScraperService;
    }

    @GetMapping
    public ResponseEntity<?> scrapeWebsite(@RequestParam String url) {

        try {
            List<ScrapedItem> items = webScraperService.scrapeWebsite(url);

            ScrapingResponse response = new ScrapingResponse(
                    url,
                    items.size(),
                    items
            );

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException | IOException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
