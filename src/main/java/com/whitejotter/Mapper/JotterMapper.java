package com.whitejotter.Mapper;

import com.whitejotter.entity.Note;

import java.util.List;

public interface JotterMapper {
    List<Note> list(String username);

    String getContent(Integer note_id);
}
