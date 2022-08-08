package com.whitejotter.entity;

import lombok.Data;

import java.text.DateFormat;
import java.util.Calendar;
import java.sql.Date;

@Data
public class Note {
    private Integer id;
    private String author;
    private String userId;
    private String title;
    private Date date;
    private String Introduction;
    private String content;
    private Boolean permissions;
    private Integer times;
    private Integer likes;

    public Note() {
    }
}
