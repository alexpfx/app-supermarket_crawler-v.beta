package br.com.alexpfx.crawler.visitor;

/**
 * Visita um url e retorna o seu conteudo em html.
 */
public interface Visitor {
    String visit(String url);
}
