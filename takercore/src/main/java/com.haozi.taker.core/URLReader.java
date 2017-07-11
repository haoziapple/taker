package com.haozi.taker.core;

/**
 * 读取url
 * Created by Administrator on 2017/7/11.
 */
public interface URLReader {
    /**
     * @param url 读取的url
     * @return html纯文本
     */
    String readURL(String url);
}
