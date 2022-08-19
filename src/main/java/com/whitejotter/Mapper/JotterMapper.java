package com.whitejotter.Mapper;

import com.whitejotter.entity.Note;

import java.util.List;

public interface JotterMapper {
    List<Note> list(String username);

    List<Note> ownlist(String username);

    List<Note> ownlistByKeyword(String Keyword);

    String getContent(Integer note_id);

    int insertNote(Note note);

    int insertContent(Note note);
}
