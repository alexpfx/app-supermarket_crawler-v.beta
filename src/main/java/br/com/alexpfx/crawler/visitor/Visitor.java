package br.com.alexpfx.crawler.visitor;

/**
 * Visita um url e retorna o seu conteudo em html.
 */
public interface Visitor {
    /**
     * Visita uma url e retorna o html.
     * @param url
     * @return
     */
    String visit(String url);
}
