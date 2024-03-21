package org.levi.demomybatispp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.levi.demomybatispp.model.Book;
import org.levi.demomybatispp.model.Category;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("""
    SELECT c.category_name FROM categories c
    INNER JOIN book_category bc ON c.id = bc.category_id
    WHERE bc.book_id = #{id}
    """)
    List<String> getALlCategoryByBookId(Integer id);
}
