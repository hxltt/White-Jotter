package com.whitejotter.controller;

import com.whitejotter.entity.Note;
import com.whitejotter.result.Result;
import com.whitejotter.result.ResultFactory;
import com.whitejotter.service.JotterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Slf4j
public class JotterController {

    @Autowired
    private JotterService jotterService;

    /**
     * 获取笔记列表
     * @param username 用户名
     * @return Reslut
     */
    @GetMapping("/api/list")
    public Result list(@RequestParam("username")String username){
        try {
            log.info("获取笔记列表");
            List<Note> list = jotterService.list(username);
            return ResultFactory.buildSuccessResult(list);
        }catch (Exception e){
            return ResultFactory.buildFailResult("获取笔记列表失败");
        }
    }

    /**
     * 获取自己的笔记列表
     * @param username 用户名
     * @return Reslut
     */
    @GetMapping("/api/ownList")
    public Result ownlist(@RequestParam("username")String username){
        try {
            List<Note> list = jotterService.ownlist(username);
            return ResultFactory.buildSuccessResult(list);
        }catch (Exception e){
            return ResultFactory.buildFailResult("获取笔记列表失败");
        }
    }

    /**
     * 获取自己的笔记列表
     * @param keyword 关键字
     * @return Reslut
     */
    @GetMapping("/api/listBykeyword")
    public Result listBykeyword(@RequestParam("keyword")String keyword){
        try {
            List<Note> list = jotterService.listByKeyword(keyword);
            return ResultFactory.buildSuccessResult(list);
        }catch (Exception e){
            return ResultFactory.buildFailResult("搜索失败");
        }
    }

    /**
     * 新增笔记
     * @param note 笔记
     * @return Reslut
     */
    @PostMapping("/api/list")
    public Result list(@RequestBody Note note){
        try {
             jotterService.insertNote(note);
            return ResultFactory.buildSuccessResult("发布成功！");
        }catch (Exception e){
            return ResultFactory.buildFailResult("发布失败！");
        }
    }

    /**
     * 获取笔记正文
     * @param noteId 笔记ID
     * @return Reslut
     */
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
