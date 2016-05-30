package br.com.alexpfx.crawler;
import java.util.*;
/**
 * Created by alexandre on 17/05/2016.
 * Recebe uma lista de urls como entrada e um listener.
 * Percorre as urls em busca de items, disparando-os para o listener.
 * Implementa a lógica de extração de items.
 */
public interface ItemCatcher<I, T> {
    void run(Collection<I> urls, ItemCatcherListener<T> listener);
}
