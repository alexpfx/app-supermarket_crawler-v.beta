package br.com.alexpfx.crawler;
import java.util.Set;

/**
 * Created by alexandre on 17/05/2016.
 */
public interface UrlCatcher {
    Set<String> extract(String url);
}
