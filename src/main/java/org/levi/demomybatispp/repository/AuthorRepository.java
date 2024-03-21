package org.levi.demomybatispp.repository;

import org.apache.ibatis.annotations.*;
import org.levi.demomybatispp.model.Author;
import org.levi.demomybatispp.model.AuthorRequest;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("""
    SELECT * FROM authors
    """)
    @Results(id="authorMapping", value = {
            @Result(property = "authorName", column = "author_name")
    })
    List<Author> getAuthor();

    @Select("""
    SELECT * FROM authors
    WHERE id = #{id}
    """)
    @ResultMap("authorMapping")
//    @Result(property = "authorName", column = "author_name")
    Author findAuthorById(Integer id);

    @Select("""
    INSERT INTO authors (author_name, gender)
    VALUES (#{authorName}, #{gender})
    RETURNING *
    """)
    @ResultMap("authorMapping")
    Author insertAuthor(AuthorRequest authorRequest);

    @Update("""
    UPDATE authors
    SET author_name = #{author.authorName}, gender = #{author.gender}
    WHERE id = #{id};
    """)
    void updateAuthor(Integer id,@Param("author") AuthorRequest authorRequest);

    @Delete("""
    DELETE FROM authors
    WHERE id = #{id}
    """)
    void deleteAuthor(Integer id);
}
