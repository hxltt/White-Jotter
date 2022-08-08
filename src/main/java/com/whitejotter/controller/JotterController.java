package com.whitejotter.controller;

import com.whitejotter.entity.Note;
import com.whitejotter.result.Result;
import com.whitejotter.result.ResultFactory;
import com.whitejotter.service.JotterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class JotterController {
    @Autowired
    private JotterService jotterService;

    @GetMapping("/api/list")
    public Result list(@RequestParam("username")String username){
        try {
            System.out.println("http://localhost:8443/api/list)");
            List<Note> list = jotterService.list(username);
            return ResultFactory.buildSuccessResult(list);
        }catch (Exception e){
            return ResultFactory.buildFailResult("获取笔记列表失败");
        }

    }
    @PostMapping("/api/list")
    public Result list(@RequestBody Note note,@RequestBody String content){
//        ,@RequestParam("content")String content
        System.out.println(note.toString());

        return null;
    }

    @GetMapping("/api/content")
    public Result getNote(@RequestParam("noteId")String noteId){
        try {
            System.out.println("http://localhost:8443/api/content)");
            String content = jotterService.getContent(Integer.parseInt(noteId));
            System.out.println(content);
            return ResultFactory.buildSuccessResult(content);
        }catch (Exception e){
            return ResultFactory.buildFailResult("获取笔记列表失败");
        }

    }
}
