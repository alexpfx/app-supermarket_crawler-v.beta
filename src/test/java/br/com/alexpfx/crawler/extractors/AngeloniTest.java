package br.com.alexpfx.crawler.extractors;

import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

/**
 * Created by alexandre on 05/06/2016.
 */
public class AngeloniTest {

    Visitor visitor;
    Parser parser;

    @Before
    public void before() {
        visitor = new HtmlUnit();
        parser = new JsoupParser();
    }

    @Test
    public void test() {
//
        Collection<String> urls = Angeloni.urlExtractor("http://www.angeloni.com.br/super/index?grupo=9", visitor, parser);
        System.out.println(urls.size());
        assertNotNull(urls);

    }


    @After
    public void after() {
        visitor = null;
        parser = null;
    }


}
