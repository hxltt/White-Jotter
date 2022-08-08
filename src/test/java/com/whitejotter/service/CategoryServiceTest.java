package com.whitejotter.service;

import com.whitejotter.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;

    @Test
    public void getAllCategoryTest() {
        List<Category> allCategory = categoryService.getAllCategory();
        for (Category category: allCategory)
            System.out.println(category.toString());
    }

    @Test
    public void getCategory() {
        System.out.println(categoryService.getCategory(2).toString());
    }


}
