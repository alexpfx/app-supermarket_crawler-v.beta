package br.com.alexpfx.crawler.visitor;
import javax.enterprise.context.*;
import javax.enterprise.inject.*;

/**
 * Created by alexandre on 18/05/2016.
 */
@ApplicationScoped
public class VisitorGenerator {

    @Produces
    @Default
    public Visitor getVisitor (){
        Visitor visitor = new HtmlUnit ();
        return visitor;
    }


}
