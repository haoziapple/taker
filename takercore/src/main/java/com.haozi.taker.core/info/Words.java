package com.haozi.taker.core.info;

/**
 * 单词信息
 * Created by Administrator on 2017/7/11.
 */
public class Words {
    private String text;

    private String type;

    private String pronounce;

    private String demoSentence;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getDemoSentence() {
        return demoSentence;
    }

    public void setDemoSentence(String demoSentence) {
        this.demoSentence = demoSentence;
    }

    @Override
    public String toString() {
        return "Words{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", pronounce='" + pronounce + '\'' +
                ", demoSentence='" + demoSentence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Words)) return false;

        Words words = (Words) o;

        return getText().equals(words.getText());
    }

    @Override
    public int hashCode() {
        return getText().hashCode();
    }
}
