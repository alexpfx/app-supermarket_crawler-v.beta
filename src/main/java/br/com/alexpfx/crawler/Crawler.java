package br.com.alexpfx.crawler;

public interface Crawler {

    void setUrlCatcher (UrlCatcher urlCatcher);
    void setItemCatcher (ItemCatcher itemCatcher);
    void setBaseUrl (String baseUrl);

    void start();
}
