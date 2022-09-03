package com.whitejotter.entity;

import lombok.Data;

@Data
public class User {
    /**
     *用户id
     */
    int id;

    /**
     *用户名
     */
    private String username;

    /**
     *用户密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    public User() {
    }

    public User(String lt1, String dsad, String sda) {
    }
}
