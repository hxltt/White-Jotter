package com.whitejotter.Mapper;

import com.whitejotter.entity.Book;
import com.whitejotter.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    /**
     * 查询所有书籍
     * @return List<Book>
     */
    List<Book> selectAll();

    /**
     * 根据书籍id或名字查询书籍是否存在
     * @return List<Book>
     */
    List<Book> selectByBook(Book book);

    /**
     * 根据书名查询书籍
     * @return Book
     */
    Book selectByTitle(Book book);

    /**
     * 根据书籍类型查询书
     * @return List<Book>
     */
    List<Book> selectAllByCategory(@Param("id") int id);

    /**
     * 根据书名或作者模糊查询
     * @return List<Book>
     */
    List<Book> selectAllByTitleLikeOrAuthorLike(@Param("title") String keyword1, @Param("author")String keyword2);

    /**
     * 加入新书
     * @return insertNum
     */
    int insertBook(Book book);

    /**
     * 更新新书
     * @return updateNum
     */
    int updateBook(Book book);

    /**
     * 根据Id删除书籍
     * @return deleteNum
     */
    int deleteById(int id);
}
