package br.com.alexpfx.crawler;

import javax.inject.*;
import java.util.*;

@Singleton
public class SMCrawler implements Crawler{

    private UrlExtractor<String, String> urlExtractor;
    private ItemCatcher itemCatcher;
    private String baseUrl;

    @Inject
    public SMCrawler(UrlExtractor urlExtractor, ItemCatcher itemCatcher, String baseUrl) {
        this.urlExtractor = urlExtractor;
        this.itemCatcher = itemCatcher;
        this.baseUrl = baseUrl;
    }

    @Override
    public void run() {
        Collection<String> urls = urlExtractor.extract(baseUrl);



        Set<String> visit = new HashSet<>();
        visit.add(baseUrl);
        Set<String> collected = new HashSet<>();

        loop(visit, collected);

        collected.forEach(e -> {

        });

    }

    public void loop(Set<String> visit, Set<String> collected) {
        do {
            final Set<String> set = new HashSet<>();
            visit.removeIf(v -> {
                set.addAll(urlExtractor.extract(v));
                return true;
            });
            set.forEach(e -> {
                if (collected.contains(e)) {
                    return;
                }
                visit.add(e);
                collected.add(e);
            });
        } while (!visit.isEmpty());
    }

    public void receive(Item item) {

    }



}
