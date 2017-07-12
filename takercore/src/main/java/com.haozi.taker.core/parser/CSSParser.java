package com.haozi.taker.core.parser;

import com.haozi.taker.core.HTMLParser;
import com.haozi.taker.core.util.JsoupUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 根据CSS-Selector解析html文件
 * Created by Administrator on 2017/7/11.
 */
public class CSSParser implements HTMLParser {
    private String xFile;

    @Override
    public void init(String html) {
        this.xFile = html;
    }

    @Override
    public String getRawText(String cssQuery) {
        String text = JsoupUtil.getRawText(xFile, cssQuery);

        return text;
    }

    @Override
    public Map<String, String> getTextMap(Map<String, String> pathMap) {
//        long start = System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> iter = pathMap.entrySet().iterator();
        Map<String, String> result = new HashMap<String, String>();

        while (iter.hasNext()) {
            Map.Entry<String, String> e = iter.next();
            String key = e.getKey();
            String text = this.getRawText(e.getValue());
            result.put(key, text);
        }
//        long end = System.currentTimeMillis();
//        long span = end - start;
//        System.out.println("解析html耗时:" + span + "ms");
        return result;
    }
}
