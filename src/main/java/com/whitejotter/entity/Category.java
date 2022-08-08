package com.whitejotter.entity;

import lombok.Data;

@Data
public class Category {
    /**
     * 书籍类型id
     */
    private Integer id;

    /**
     *书籍类型名称
     */
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
