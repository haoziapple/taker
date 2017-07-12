package com.haozi.taker.core.parser;

import com.haozi.taker.core.info.Words;
import com.haozi.taker.core.util.HttpUtil;
import com.haozi.taker.core.util.JsoupUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析爱词霸页面的单词信息
 * Created by Administrator on 2017/7/11.
 */
public class ACBWordsParser {

    private static final String HOST = "http://www.iciba.com/";

    private static final String HOST2 = "http://dict.cn/";

    private static final String SENTENCE_SELECT = "#content > div.main > div.section.sent > div.layout.sort > ol:nth-child(2) > li";

    private static final String TYPE_SELECT = "body > div.screen > div.container > div.container-left > div.js-base-info > div > div > ul > li > span";

    private static final String MEAN_SELECT = "body > div.screen > div.container > div.container-left > div.js-base-info > div > div > ul > li > p";

    private static final String PRON_SELECT = "body > div.screen > div.container > div.container-left > div.js-base-info > div > div > div.clearfix:nth-child(1) > div.base-top-voice > div.base-speak > span > span";

    private static final String DEMO_ENG_SELECT = "body > div.screen > div.container > div.container-left > div.js-main-content > div.info-article.article-tab > div > div:nth-child(1) > div:nth-child(1) > div > p.p-english.family-english.size-english";

    private static final String DEMO_CHS_SELECT = "body > div.screen > div.container > div.container-left > div.js-main-content > div.info-article.article-tab > div > div:nth-child(1) > div:nth-child(1) > div > p.p-chinese.family-chinese.size-chinese";

    private static final Map<String, String> selectMap = new HashMap<String, String>();

    static {
        selectMap.put("type", TYPE_SELECT);
        selectMap.put("mean", MEAN_SELECT);
        selectMap.put("pronounce", PRON_SELECT);
        selectMap.put("demo_eng", DEMO_ENG_SELECT);
        selectMap.put("demo_chs", DEMO_CHS_SELECT);
    }


    public static Words getWords(final String word) {
        String html = HttpUtil.readURL(HOST + word);
        CSSParser parser = new CSSParser();
        parser.init(html);

        final Map<String, String> parseResult = parser.getTextMap(selectMap);

        // 爱词霸的例句使用了前端js，改用海词的例句
        String html_sentence = HttpUtil.readURL(HOST2 + word);
        final String sentence = JsoupUtil.getRawText(html_sentence, SENTENCE_SELECT);

        Words result = new Words() {
            {
                setText(word);
                setMean(parseResult.get("mean").replaceAll("<span>", "").replaceAll("</span>", ""));
                setType(parseResult.get("type"));
                setPronounce(parseResult.get("pronounce"));
                setDemoSentence(sentence);
            }
        };
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getWords("success"));
    }
}
