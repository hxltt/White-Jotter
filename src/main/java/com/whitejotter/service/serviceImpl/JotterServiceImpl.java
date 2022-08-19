package com.whitejotter.service.serviceImpl;

import com.whitejotter.Mapper.JotterMapper;
import com.whitejotter.Mapper.UserMapper;
import com.whitejotter.entity.Note;
import com.whitejotter.entity.User;
import com.whitejotter.service.JotterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JotterServiceImpl implements JotterService {

    @Autowired
    private JotterMapper jotterMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Note> list(String username) {
        return jotterMapper.list(username);
    }

    @Override
    public List<Note> ownlist(String username) {
        return jotterMapper.ownlist(username);
    }

    @Override
    public List<Note> listByKeyword(String Keyword) {
        return jotterMapper.ownlistByKeyword(Keyword);
    }

    @Override
    public String getContent(Integer noteId) {
        return jotterMapper.getContent(noteId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertNote(Note note) {
        //根据用户名获取用户ID
        String author = note.getAuthor();
        User user = userMapper.selectByUserName(author);
        note.setUserId(String.valueOf(user.getId()));
        //插入note
        jotterMapper.insertNote(note);
        //插入content
        jotterMapper.insertContent(note);
    }
}
