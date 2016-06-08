package br.com.alexpfx.crawler.visitor;
import java.io.*;

/**
 * Visita um url e retorna o seu conteudo em html.
 */
public interface Visitor {
    /**
     * Visita uma url e retorna o html.
     * @param url
     * @return
     */
    String visit(String url) ;

    default String visit (String url, String javascript) {
        throw new IllegalArgumentException("método não implementado no cliente");
    }

    default <T> T visit (String url, Class <T> returnType) throws IOException{
        throw new IllegalArgumentException("método não implementado no cliente");
    }


}
