package br.com.alexpfx.crawler;

/**
 * Created by alexandre on 17/05/2016.
 */
public interface ItemCatcher {
    void start(ItemCatcherListener listener);
    void push (String url);
}
