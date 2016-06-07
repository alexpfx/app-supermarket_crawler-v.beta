package br.com.alexpfx.crawler.visitor;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.*;

public class HtmlUnit implements Visitor {

    private final WebClient client = this.initClient();

    @Override
    public String visit(String url) {
        HtmlPage p = null;
        try {
            p = client.getPage(url);
            return p.asXml();
        } catch (IOException e) {
            return "";
        }
    }

    private WebClient initClient() {
        WebClient client;
        client = new WebClient(BrowserVersion.FIREFOX_38);
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setThrowExceptionOnScriptError(false);
        client.setAjaxController(new NicelyResynchronizingAjaxController());
        client.waitForBackgroundJavaScript(3000);
        return client;
    }


}