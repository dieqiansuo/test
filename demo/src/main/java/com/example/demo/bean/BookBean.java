package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/8/6.
 */
@Component
@ConfigurationProperties(prefix = "book")
@PropertySource("classpath:book.properties")//指定配置文件位置
public class BookBean {
    private String name;
    private String author;
    private String pinyin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
