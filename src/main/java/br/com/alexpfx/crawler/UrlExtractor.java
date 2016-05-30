package br.com.alexpfx.crawler;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import java.util.Collection;

import java.util.Set;

/**
 * Created by alexandre on 17/05/2016.
 * Extrai recursivamente ou não todas as urls de uma url base.
 */
public interface UrlExtractor<O, I> {
    Collection<O> extract(I input);
}
