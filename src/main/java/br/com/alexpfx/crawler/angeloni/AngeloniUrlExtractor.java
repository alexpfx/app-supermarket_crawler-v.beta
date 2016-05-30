package br.com.alexpfx.crawler.angeloni;

import br.com.alexpfx.crawler.*;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import javax.inject.*;
import java.util.*;


/**
 * Created by alexandre on 17/05/2016.
 */
public class AngeloniUrlExtractor  implements UrlExtractor<String, String> {

    private static final String BASE_URI = "http://www.angeloni.com.br";


    private Visitor visitor;

    private Parser<Document> parser;

    @Inject
    public void visitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @Inject
    public void parser(Parser parser) {
        this.parser = parser;
    }

    public Collection<String> extract(String baseUrl) {
        String html = visitor.visit(baseUrl);
        Document doc = parser.parse(html);
        doc.setBaseUri(BASE_URI);
        Elements elements = doc.select("a.lnkTp01 ");
        Elements tp02 = doc.select("a.lnkTp02 ");
        elements.addAll(tp02);
        return extract(elements);
    }

    private Set<String> extract(Elements elements) {
        Set<String> set = new HashSet<>();
        elements.forEach(e -> {
            String href = e.attr("abs:href");
            set.add(href);
        });
        return set;
    }


}
