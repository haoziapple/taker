package com.haozi.taker.core.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * jsoup工具类
 * Created by Administrator on 2017/7/11.
 */
public class JsoupUtil {

    /**
     * 根据css选择器读取html文本
     *
     * @param html
     * @param cssQuery
     * @return
     */
    public static String getRawText(String html, String cssQuery) {
        Document doc = Jsoup.parse(html);
        Elements text = doc.select(cssQuery);
        StringBuilder sb = new StringBuilder("");
        for(Element el:text)
        {
            sb.append(el.html()).append(" ");
        }
        return sb.toString();
    }


    public static void test() {
        try {
            Document doc = Jsoup.connect("http://www.iciba.com/apple").get();
            Elements els = doc.select("body > div.screen > div.container > div.container-left > div.js-base-info > div > div > ul > li ");

            System.out.println(els.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "http://www.iciba.com/apple";
        String cssQuery = "body > div.screen > div.container > div.container-left > div.js-base-info > div > div > ul > li";
        String html = HttpUtil.readURL(url);

        String text = JsoupUtil.getRawText(html, cssQuery);

        System.out.println(text);

        String a = JsoupUtil.getRawText(text, "p > span");
        System.out.println();
    }

}


