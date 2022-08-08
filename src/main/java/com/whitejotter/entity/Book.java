package com.whitejotter.entity;

import lombok.Data;

@Data
public class Book {
    /**
     * id
     */
    private Integer id;

    /**
     * 封面
     */
    private String cover;

    /**
     *书名
     */
    private String title;

    /**
     *作者
     */
    private String author;

    /**
     *出版日期
     */
    private String date;

    /**
     *出版社
     */
    private String press;

    /**
     *简介
     */
    private String abs;

    /**
     *书籍类型id
     */
    private Integer cid;

    /**
     *s书籍类型
     */
    private Category category;

    public Book() {
    }

    public Book(Integer id, String cover, String title, String author, String date,
                String press, String abs, Integer cid) {
        this.id = id;
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
        this.cid = cid;
    }

    public Book(String cover, String title, String author, String date, String press,
                String abs, Integer cid) {
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
        this.cid = cid;
    }

    public Book(String cover, String title, String author, String date, String press,
                String abs, Integer cid, Category category) {
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
        this.cid = cid;
        this.category = new Category(category.getId(),category.getName());
    }

    public Book(Integer id, String cover, String title, String author, String date,
                String press, String abs, Integer cid, Category category) {
        this.id = id;
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
        this.cid = cid;
        this.category = category;
    }

}
