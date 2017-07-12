package com.haozi.taker.service.controller;

import com.haozi.taker.core.info.Words;
import com.haozi.taker.core.parser.ACBWordsParser;
import com.haozi.taker.core.util.FileUtil;
import com.haozi.taker.service.dao.WordsMapper;
import com.haozi.taker.service.po.WordsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

@RestController
@RequestMapping("/word")
public class WordController {

    private static final Logger logger = LoggerFactory.getLogger(WordController.class);

    @Autowired
    private WordsMapper wordsMapper;

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public void submit(@RequestParam String character) {
        long start = System.currentTimeMillis();
        logger.info("录入单词：" + character);
        String path = "E:\\words\\" + character;
        List<String> words = FileUtil.getTrimmedList(FileUtil.readFilesName(path));
        long span1 = System.currentTimeMillis() - start;
        logger.info("获取文件目录单词耗时:" + span1 + "ms, 开始录入数据库");
        for (String s : words) {
            wordsMapper.insert(s);
        }
        long span2 = System.currentTimeMillis() - start;
        logger.info("录入完成！总耗时：" + span2 + "ms");
    }

    @RequestMapping(value = "/parse", method = RequestMethod.GET)
    public void parse(@RequestParam String character) {
        long start = System.currentTimeMillis();
        logger.info("爬取开始");
        List<String> wordsInfos = wordsMapper.getUnparsed();
        while (wordsInfos != null && wordsInfos.size() > 0) {
            logger.info("爬取单词：" + wordsInfos);
            for (String word : wordsInfos) {
                Words resultWord = ACBWordsParser.getWords(word);
                wordsMapper.update(resultWord);
            }
            wordsInfos = wordsMapper.getUnparsed();
        }
        long span2 = System.currentTimeMillis() - start;
        logger.info("爬取完成！总耗时：" + span2 + "ms");
    }
}
