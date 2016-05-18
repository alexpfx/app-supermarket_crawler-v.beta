package br.com.alexpfx.crawler.parser;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import java.nio.charset.*;

/**
 * Created by alexandre on 17/05/2016.
 */
public class JsoupParser implements Parser<Document> {
    private static final String CHARSET = "ISO8859_1";

    @Override
    public Document parse (String html){
        Document doc = Jsoup.parse (html);
        doc.charset(Charset.forName(CHARSET));
        return doc;
    }


}
