package com.cognifyz.task6_web_scraping.service;

import com.cognifyz.task6_web_scraping.model.ScrapedItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class WebScraperService {

    public List<ScrapedItem> scrapeWebsite(String url) throws IOException {

        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("Website URL cannot be empty");
        }

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .get();

        Elements links = document.select("a");

        List<ScrapedItem> items = new ArrayList<>();

        for (Element link : links) {

            String title = link.text();
            String href = link.absUrl("href");

            if (!title.isBlank() && !href.isBlank()) {
                items.add(new ScrapedItem(title, href));
            }
        }

        return items;
    }

}
