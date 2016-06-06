package br.com.alexpfx.crawler;
import java.util.*;
/**
 * Created by alexandre on 05/06/2016.
 */
public interface ItemExtractor {
    void extract(Collection<String> urls, ItemExtractedListener<Item> listener);
}
