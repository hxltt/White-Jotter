package com.whitejotter.service.serviceImpl;

import com.whitejotter.Mapper.CategoryMapper;
import com.whitejotter.entity.Category;
import com.whitejotter.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 获取所有书籍的类型
     * @return List<Category>
     */
    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectAllCategory();
    }

    /**
     * 根据书类型id查询书籍类型
     * @return Category
     */
    @Override
    public Category getCategory(int id) {
        return categoryMapper.selectById(id);
    }
}
