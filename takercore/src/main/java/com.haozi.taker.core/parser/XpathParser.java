package com.haozi.taker.core.parser;

import com.haozi.taker.core.HTMLParser;

import java.util.Map;

/**
 * 根据xpath解析html文件
 * Created by Administrator on 2017/7/11.
 */
public class XpathParser implements HTMLParser {
    private String xFile;

    @Override
    public void init(String html) {
        this.xFile = html;
    }

    @Override
    public String getRawText(String Xpath) {
        return null;
    }

    @Override
    public Map<String, String> getTextMap(Map<String, String> pathMap) {
        return null;
    }
}
