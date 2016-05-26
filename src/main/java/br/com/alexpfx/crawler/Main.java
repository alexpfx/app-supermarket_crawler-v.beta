package br.com.alexpfx.crawler;

import br.com.alexpfx.crawler.di.*;
import dagger.*;

import javax.inject.*;

public class Main {

    @Singleton
    @Component(modules = {CrawlerModule.class})
    public interface CrawlerComponent {
        Application createApplication();
    }

    public static void main(String[] args) {
        CrawlerComponent component = DaggerMain_CrawlerComponent.builder().build();
        Application app = component.createApplication ();
        app.run ();
    }


}
