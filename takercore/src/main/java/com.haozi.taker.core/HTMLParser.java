package com.haozi.taker.core;

import java.util.Map;

/**
 * 解析html文本
 * Created by Administrator on 2017/7/11.
 */
public interface HTMLParser {
    /**
     * 初始化
     * @param html
     */
    void init(String html);

    /**
     * 根据Xpath取出文本值
     * @param Xpath
     * @return
     */
    String getRawText(String Xpath);

    /**
     * 批量获取
     * @param pathMap
     * @return
     */
    Map<String, String> getTextMap(Map<String, String> pathMap);
}
