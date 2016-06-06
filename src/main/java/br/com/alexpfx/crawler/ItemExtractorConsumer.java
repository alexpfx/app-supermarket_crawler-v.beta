package br.com.alexpfx.crawler;
import java.util.*;
import br.com.alexpfx.crawler.visitor.*;
import br.com.alexpfx.crawler.parser.*;
import java.util.function.*;


/**
 * Created by alexandre on 05/06/2016.
 */
@FunctionalInterface
public interface ItemExtractorConsumer {
    void accept(Collection<String> urls, ItemExtractedListener<Item> listener, Visitor visitor, Parser parser);
}
