package com.haozi.taker.core.parser;

import com.haozi.taker.core.util.HttpUtil;
import com.haozi.taker.core.util.JsoupUtil;

/**
 * 解析爱词霸页面的单词信息
 * Created by Administrator on 2017/7/11.
 */
public class ACBWordsParser {

    private static final String HOST = "http://www.iciba.com/";

    private static final String TYPE_SELECT = "body > div.screen > div.container > div.container-left > div.js-base-info > div > div > ul > li > span";

    private static final String MEAN_SELECT ="body > div.screen > div.container > div.container-left > div.js-base-info > div > div > ul > li > p";

    public static String getType(String word) {
        String html = HttpUtil.readURL(HOST + word);
        String type = JsoupUtil.getRawText(html, TYPE_SELECT);

        return type;
    }

    public static void main(String[] args) {
        System.out.println(getType("get"));
    }
}
