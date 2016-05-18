package br.com.alexpfx.crawler;

import javax.enterprise.inject.*;
import java.util.*;

public
@Alternative
class SMCrawler implements Crawler, ItemCatcherListener {

    private UrlCatcher urlCatcher;
    private ItemCatcher itemCatcher;
    private String baseUrl;

    @Override
    public void start() {
        Set<String> visit = new HashSet<>();
        visit.add(baseUrl);
        Set<String> collected = new HashSet<>();

        loop(visit, collected);

        collected.forEach(e -> {
            itemCatcher.push(e);
        });
        itemCatcher.start(this);
    }

    public void loop(Set<String> visit, Set<String> collected) {
        do {
            final Set<String> set = new HashSet<>();
            visit.removeIf(v -> {
                set.addAll(urlCatcher.extract(v));
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
