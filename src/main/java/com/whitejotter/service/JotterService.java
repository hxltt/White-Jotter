package com.whitejotter.service;

import com.whitejotter.entity.Note;

import java.util.List;

public interface JotterService {
    List<Note> list(String usernamer);

    List<Note> ownlist(String usernamer);

    String getContent(Integer noteId);

    void insertNote(Note note);

    List<Note> listByKeyword(String Keyword);
}
