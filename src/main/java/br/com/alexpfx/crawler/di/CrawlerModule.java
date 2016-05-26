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
    @Named ("htmlUnit")
    Visitor providesVisitor() {
        Visitor visitor = new HtmlUnit();
        return visitor;
    }

    @Provides
    @Singleton
    @Named ("jsoup")
    Parser providesParser() {
        Parser parser = new JsoupParser();
        return parser;
    }


    @Provides
    @Singleton
    @Named ("angeloni")
    UrlCatcher providesUrlCatcher(@Named ("htmlUnit") Visitor visitor, @Named("jsoup") Parser parser) {
        UrlCatcher urlCatcher = new AngeloniUrlCatcher();
        urlCatcher.setVisitor(visitor);
        urlCatcher.setParser(parser);
        return urlCatcher;
    }

    @Provides
    @Singleton
    Crawler providesCrawler(@Named ("angeloni") UrlCatcher urlCatcher, @Named ("angeloni") ItemCatcher itemCatcher) {
        Crawler crawler = new SMCrawler();
        crawler.setUrlCatcher(urlCatcher);
        crawler.setItemCatcher(itemCatcher);
        return crawler;
    }

    @Provides
    @Singleton
    @Named ("angeloni")
    ItemCatcher providesItemCatcher (){
        return new ItemCatcher (){
            public void start (ItemCatcherListener l){}
            public void push (String url){};
        };

    }




}
