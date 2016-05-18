package br.com.alexpfx.crawler;
import javax.inject.Inject;
import javax.inject.Singleton;
import br.com.alexpfx.crawler.*;

@Singleton
public class Application {

    @Inject
    private Crawler crawler;

	public void run() {


        crawler.start();


	}
}
