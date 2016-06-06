package br.com.alexpfx.crawler;

import javax.inject.*;
import java.util.*;
import java.util.function.*;

@Singleton
public class SMCrawler implements Crawler, ItemExtractedListener<Item> {

    private String baseUrl;
    private UrlExtractor urlExtractor;
    private ItemExtractor itemExtractor;

    @Inject
    public SMCrawler(UrlExtractor urlExtractor,
                     ItemExtractor itemExtractor, String baseUrl) {
        this.urlExtractor = urlExtractor;
        this.itemExtractor = itemExtractor;
        this.baseUrl = baseUrl;
    }

    @Override
    public void run() {
        Collection<String> urls = urlExtractor.extract(baseUrl);
        itemExtractor.extract(urls, this);

    }

    public void receive(Item item) {


    }


}
