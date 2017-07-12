package com.haozi.taker.service.dao;

import com.haozi.taker.core.info.Words;
import com.haozi.taker.service.po.WordsInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface WordsMapper {

    // 插入单词
    void insert(String text);

    // 获取未处理的单词
    List<String> getUnparsed();

    // 更新处理信息
    void update(Words words);
}
