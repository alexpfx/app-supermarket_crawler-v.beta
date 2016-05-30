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
        UrlExtractor urlExtractor = new AngeloniUrlExtractor();

        return urlExtractor;
    }

    @Provides
    @Singleton
    @Named("angeloni")
    String providesBaseUrl() {
        return "http://www.angeloni.com.br/super/index";
    }

    @Provides
    @Singleton
    Crawler providesCrawler(@Named("angeloni") UrlExtractor urlExtractor, @Named("angeloni") ItemCatcher itemCatcher,
                            @Named("angeloni") String baseUrl) {
        return new SMCrawler(urlExtractor, itemCatcher, baseUrl);
    }

    @Provides
    @Singleton
    @Named("angeloni")
    ItemCatcher providesItemCatcher() {
        return new AngeloniItemCatcher((item) -> System.out.println(item));
    }


}
