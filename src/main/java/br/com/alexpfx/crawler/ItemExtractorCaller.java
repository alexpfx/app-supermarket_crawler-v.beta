package br.com.alexpfx.crawler;
import java.util.*;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;


/**
 * Created by alexandre on 05/06/2016.
 */
public class ItemExtractorCaller implements ItemExtractor {
    private Visitor visitor;
    private Parser parser;
    private ItemExtractorConsumer itemExtractorConsumer;

    public ItemExtractorCaller(Visitor visitor, Parser parser, ItemExtractorConsumer consumer) {
        this.itemExtractorConsumer = consumer;
    }


    public void extract(Collection<String> urls, ItemExtractedListener<Item> listener) {
        itemExtractorConsumer.accept(urls, listener, visitor, parser);
    }

}
