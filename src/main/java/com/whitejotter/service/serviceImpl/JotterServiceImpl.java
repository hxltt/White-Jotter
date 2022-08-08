package com.whitejotter.service.serviceImpl;

import com.whitejotter.Mapper.JotterMapper;
import com.whitejotter.entity.Note;
import com.whitejotter.service.JotterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JotterServiceImpl implements JotterService {

    @Autowired
    private JotterMapper jotterMapper;

    @Override
    public List<Note> list(String username) {
        return jotterMapper.list(username);
    }

    @Override
    public String getContent(Integer noteId) {
        return jotterMapper.getContent(noteId);
    }
}
