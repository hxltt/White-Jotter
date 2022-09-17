package com.whitejotter.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * 用户个人信息
 */
@Data
public class UserInfo{
    /**
     * 头像
     */
    private String profilePicture;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 个人描述
     */
    private String description;

    /**
     * 性别
     */
    private String gender;

    /**
     * 地址
     */
    private String address;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 职业
     */
    private String profession;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 电话号码
     */
    private Long phone;

    public UserInfo() {
    }
}
