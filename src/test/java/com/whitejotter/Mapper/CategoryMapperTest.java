package com.whitejotter.Mapper;

import com.whitejotter.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void selectAllCategoryTest(){
        List<Category> allCategory = categoryMapper.selectAllCategory();
        for (Category category: allCategory)
            System.out.println(category.toString());
    }

    @Test
    void selectByIdTest(){
        Category category1 = categoryMapper.selectById(1);
        System.out.println(category1.toString());
        Category category2 = categoryMapper.selectById(3);
        System.out.println(category2.toString());
    }

    @Test
    void selectByIdName(){
        Category category1 = categoryMapper.selectByName("小说");
        System.out.println(category1.toString());
    }
}
