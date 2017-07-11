package com.haozi.taker.core.parser;

import com.haozi.taker.core.URLReader;
import com.haozi.taker.core.util.HttpUtil;

/**
 * Created by Administrator on 2017/7/11.
 */
public class RawReader implements URLReader{
    @Override
    public String readURL(String url) {
        return HttpUtil.readURL(url);
    }

    public static void main(String[] args)
    {
        RawReader reader = new RawReader();
        String html =reader.readURL("http://www.iciba.com/apple");
        System.out.print(html);
    }

}



