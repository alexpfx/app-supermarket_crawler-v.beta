package br.com.alexpfx.crawler.parser;

import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by alexandre on 18/05/2016.
 */
public class JsoupParserTest {

    Parser<Document> parser;

    @Before
    public void setUp() {
        parser = new JsoupParser();

    }


    @Test
    public void testParse() {
        String html = "<html><body><a href='http://www.gmail.com'></a> </body></html>";


        Document doc = parser.parse(html);
        Elements links = doc.select("a[href]");

        assertNotNull(links);
        assertEquals(1, links.size());
    }


}
