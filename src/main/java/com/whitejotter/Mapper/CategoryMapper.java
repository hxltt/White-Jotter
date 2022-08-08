package com.whitejotter.Mapper;

import com.whitejotter.entity.Category;
import java.util.List;

public interface CategoryMapper {
    /**
     * 查找所有的书籍类型信息
     * @return List<Category>
     */
    List<Category> selectAllCategory();

    /**
     *根据类型id查询书籍的类型
     * @return Category
     */
    Category selectById(int id);

    /**
     *根据类型名称name查询书籍的类型
     * @return Category
     */
    Category selectByName(String name);
}
