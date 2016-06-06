package br.com.alexpfx.crawler;
import java.util.*;
/**
 * Created by alexandre on 04/06/2016.
 */
public interface UrlExtractor {
    public Collection<String> extract (String baseUrl);
}
