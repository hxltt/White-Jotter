package com.whitejotter.service;

import com.whitejotter.entity.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JotterServiceTest {
    @Autowired
    JotterService jotterService;

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
}
