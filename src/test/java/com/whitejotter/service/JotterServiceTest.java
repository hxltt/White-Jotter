package com.whitejotter.service;

import com.whitejotter.Mapper.UserMapper;
import com.whitejotter.entity.Note;
import com.whitejotter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JotterServiceTest {
    @Autowired
    JotterService jotterService;

    @Autowired
    UserMapper userMapper;

    @Test
    void list(){
        List<Note> list = jotterService.list("admin");
        for (Note note : list) {
            System.out.println(note.toString());
        }
    }

    @Test
    void getContent(){
        String content = jotterService.getContent(1);
        System.out.println(content);
    }

    @Test
    void insertNote(){
        Note note = new Note();
        note.setAuthor("admin");
        note.setTitle("adsfv");
        note.setIntroduction("sdfgbh");
        note.setContent("adsefrtgjhnwrahef");
        Date date = new Date(2022,8,10);
        note.setDate(date);
        note.setPermissions(false);
        jotterService.insertNote(note);
    }

    @Test
    void listByKeyword(){
        List<Note> note = jotterService.listByKeyword("孔乙己");
        System.out.println(Arrays.toString(note.toArray()));
    }
}
