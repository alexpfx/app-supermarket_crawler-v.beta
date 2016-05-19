package br.com.alexpfx.crawler;
import org.junit.*;
import static org.junit.Assert.*;
import br.com.alexpfx.crawler.angeloni.*;

public class SMCrawlerTest {
    SMCrawler smCrawler;
    @Before
    public void setUp (){
        smCrawler = new SMCrawler ();
        smCrawler.setBaseUrl("http://angeloni.com.br/super/index");

        smCrawler.setUrlCatcher (new AngeloniUrlCatcher ());




    }

    @Test
    public void test (){

    }

}