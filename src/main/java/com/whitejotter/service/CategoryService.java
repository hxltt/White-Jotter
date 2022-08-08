package com.whitejotter.service;

import com.whitejotter.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategory(int id);
}
