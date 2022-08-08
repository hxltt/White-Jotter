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

    public User(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
