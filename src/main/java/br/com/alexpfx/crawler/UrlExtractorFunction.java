package br.com.alexpfx.crawler;

import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import java.util.*;

/**
 * Created by alexandre on 04/06/2016.
 */
@FunctionalInterface
public interface UrlExtractorFunction {
    Collection<String> apply(String baseUrl, Visitor visitor, Parser parser);
}
