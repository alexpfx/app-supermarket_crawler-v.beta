package br.com.alexpfx.crawler.di;

import br.com.alexpfx.crawler.*;
import br.com.alexpfx.crawler.extractors.*;
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
    UrlExtractor providesUrlExtractorCaller(@Named("htmlUnit") Visitor visitor, @Named("jsoup") Parser parser) {
        UrlExtractorCaller urlExtractorCaller = new UrlExtractorCaller(visitor, parser, Angeloni::urlExtractor);
        return urlExtractorCaller;
    }

    @Provides
    @Singleton
    @Named("angeloni")
    ItemExtractor providesItemExtractorCaller(@Named("htmlUnit") Visitor visitor, @Named("jsoup") Parser parser) {
        ItemExtractorCaller caller = new ItemExtractorCaller(visitor, parser, Angeloni::itemExtractor);
        return caller;
    }


    @Provides
    @Singleton
    Crawler providesCrawler(@Named("angeloni") UrlExtractor urlExt, @Named("angeloni") ItemExtractor itemExt) {
        return new SMCrawler(urlExt, itemExt,
                             ANGELONI_BASE_URL);
    }


}
