package br.com.alexpfx.crawler;

import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import java.util.*;

/**
 * Created by alexandre on 04/06/2016.
 */
public class UrlExtractorCaller implements UrlExtractor{
    private Visitor visitor;
    private Parser parser;
    private UrlExtractorFunction urlExtractorFunction;

    public UrlExtractorCaller(Visitor visitor, Parser parser, UrlExtractorFunction urlExtractorFunction) {
        this.visitor = visitor;
        this.parser = parser;
        this.urlExtractorFunction = urlExtractorFunction;
    }


    public final Collection<String> extract(String baseUrl) {
        return urlExtractorFunction.apply(baseUrl, visitor, parser);
    }
}
