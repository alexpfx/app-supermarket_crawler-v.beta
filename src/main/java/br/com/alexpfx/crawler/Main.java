package br.com.alexpfx.crawler;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {


    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Application app = container.instance().select(Application.class).get();
        app.run();
        weld.shutdown();
    }


}
