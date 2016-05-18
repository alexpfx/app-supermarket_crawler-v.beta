package br.com.alexpfx.crawler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class CrawlerGenerator {

    @Produces
    @Default
    public Crawler getSMCrawler() {
        SMCrawler sm = new SMCrawler();

        return sm;
    }

}
