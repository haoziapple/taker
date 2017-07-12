package com.haozi.taker.service.po;

import com.haozi.taker.core.info.Words;

/**
 * Created by Administrator on 2017/7/12.
 */
public class WordsInfo extends Words {
    private String id;

    private String parsed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParsed() {
        return parsed;
    }

    public void setParsed(String parsed) {
        this.parsed = parsed;
    }
}
