package br.com.alexpfx.crawler.di;


import br.com.alexpfx.crawler.*;
import br.com.alexpfx.crawler.angeloni.*;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import dagger.*;

import javax.inject.*;

/**
 * Created by alexandre on 23/05/2016.
 */
@Module
public class CrawlerModule {

    public static final String ANGELONI_BASE_URL = "http://www.angeloni.com.br/super/index";

    @Provides
    @Singleton
    @Named("htmlUnit")
    Visitor providesVisitor() {
        return new HtmlUnit();
    }

    @Provides
    @Singleton
    @Named("jsoup")
    Parser providesParser() {
        return new JsoupParser();
    }


    @Provides
    @Singleton
    @Named("angeloni")
    UrlExtractor providesUrlCatcher(@Named("htmlUnit") Visitor visitor, @Named("jsoup") Parser parser) {
        UrlExtractorCaller urlExtractorCaller = new UrlExtractorCaller(visitor, parser, UrlExtractors::angeloni);

        return urlExtractorCaller;
    }


    @Provides
    @Singleton
    Crawler providesCrawler(@Named("angeloni") UrlExtractor caller) {
        return new SMCrawler(caller, ItemExtractors::angeloni,
                             ANGELONI_BASE_URL);
    }


}
