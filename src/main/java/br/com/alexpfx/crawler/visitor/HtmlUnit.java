package br.com.alexpfx.crawler.visitor;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;


import java.io.*;

public class HtmlUnit implements Visitor {

    private final WebClient client = this.initClient();

    @Override
    public String visit(String url) {
        Page p = null;
        try {
            p = visit(url, Page.class);
            //            ScriptResult o = p.executeJavaScript("javascript:changeItemsPerPage(480);");
            //            HtmlPage pp = (HtmlPage) o.getNewPage();
            //            boolean isHtml = pp.isHtmlPage ();
            //
            //            String ppAsXml = pp.asXml ();
            return ((HtmlPage)p).asXml();

        } catch (IOException e) {
            return "";
        }
    }


    public <T> T visit(String url, Class<T> returnType) throws IOException{
        return client.getPage(url);
    }


    private WebClient initClient() {
        WebClient client;
        client = new WebClient(BrowserVersion.FIREFOX_38);
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setThrowExceptionOnScriptError(false);
        client.setAjaxController(new NicelyResynchronizingAjaxController());
        client.waitForBackgroundJavaScript(20000);

        return client;
    }


}