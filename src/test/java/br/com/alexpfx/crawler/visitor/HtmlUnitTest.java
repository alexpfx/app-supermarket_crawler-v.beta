package br.com.alexpfx.crawler.visitor;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by alexandre on 18/05/2016.
 */
public class HtmlUnitTest {


    Visitor visitor;

    @Before
    public void setUp() {
        visitor = new HtmlUnit();
    }

    @Test
    public void testVisit() {
        String html = visitor.visit("http://www.google.com");
        assertNotNull(html);
        System.out.println(html);


    }


}
