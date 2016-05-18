package br.com.alexpfx.crawler.parser;

/**
 * Created by alexandre on 17/05/2016.
 */
public interface Parser <T>{
    T parse (String html);
}
