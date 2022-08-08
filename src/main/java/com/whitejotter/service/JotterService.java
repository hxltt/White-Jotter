package com.whitejotter.service;

import com.whitejotter.entity.Note;

import java.util.List;

public interface JotterService {
    List<Note> list(String usernamer);
    String getContent(Integer noteId);
}
