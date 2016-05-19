package br.com.alexpfx.crawler.angeloni;

import br.com.alexpfx.crawler.*;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import org.jsoup.nodes.*;
import java.util.*;
import org.jsoup.select.*;
import javax.enterprise.inject.*;
import javax.inject.Inject;




/**
 * Created by alexandre on 17/05/2016.
 */
public class AngeloniUrlCatcher implements UrlCatcher {

    private static final String BASE_URI = "http://www.angeloni.com.br";

    @Inject
    private Visitor visitor;

    private Parser<Document> parser;


    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Set<String> extract(String url) {
        String html = visitor.visit(url);
        Document doc = parser.parse(html);
        doc.setBaseUri (BASE_URI);
        Elements elements = doc.select("a.lnkTp01 ");
        Elements tp02 = doc.select("a.lnkTp02 ");
        elements.addAll(tp02);
        return extract(elements);
    }

    private Set<String> extract (Elements elements){
        Set<String> set = new HashSet <> ();
        elements.forEach (e -> {
            String href = e.attr ("abs:href");
            set.add (href);
        });
        return set;
    }
}
