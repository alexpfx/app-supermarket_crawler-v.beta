package br.com.alexpfx.crawler;

import javax.inject.*;

public class Application {

    private final Crawler crawler;

    @Inject
    Application(Crawler crawler) {
        this.crawler = crawler;
    }

    public void run() {
        crawler.run();
    }
}
