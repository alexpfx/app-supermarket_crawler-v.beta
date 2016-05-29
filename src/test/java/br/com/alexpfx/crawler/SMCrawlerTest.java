package br.com.alexpfx.crawler;

import br.com.alexpfx.crawler.angeloni.*;
import org.junit.*;

import static org.junit.Assert.*;

public class SMCrawlerTest {
    SMCrawler smCrawler;

    @Before
    public void setUp() {
        smCrawler = new SMCrawler(new AngeloniUrlCatcher(), new AngeloniItemCatcher(),
                                  "http://angeloni.com.br/super/index");
    }

    @Test
    public void test() {

    }

}