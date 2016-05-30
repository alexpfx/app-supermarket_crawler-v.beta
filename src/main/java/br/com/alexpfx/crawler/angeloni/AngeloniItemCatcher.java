package br.com.alexpfx.crawler.angeloni;

import java.util.*;
import br.com.alexpfx.crawler.*;


/**
 * Created by alexandre on 29/05/2016.
 */
public class AngeloniItemCatcher implements ItemCatcher<String, Item> {
    private ItemCatcherListener listener;

    private List<String> list = new LinkedList<>();

    public AngeloniItemCatcher (){
        this.listener = (item) -> System.out.println(item);
    }
    public AngeloniItemCatcher(ItemCatcherListener listener) {
        this.listener = listener;
    }

    public void listener(ItemCatcherListener listener) {
        this.listener = listener;
    }

    public void push(String url) {
        this.push(url);
    }
    public void run(Collection<String> urls, ItemCatcherListener<Item> listener){

    }

}
