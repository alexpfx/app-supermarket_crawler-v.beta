package br.com.alexpfx.crawler;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;

import java.util.Set;

/**
 * Created by alexandre on 17/05/2016.
 */
public interface UrlCatcher {
    Set<String> extract(String url);
    void setVisitor (Visitor visitor);
    void setParser (Parser parser);
}
