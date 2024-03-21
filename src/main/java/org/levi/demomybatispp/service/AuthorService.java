package org.levi.demomybatispp.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.levi.demomybatispp.model.Author;
import org.levi.demomybatispp.model.AuthorRequest;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AuthorService {
    List<Author> getAllAuthor();

    Author getAuthorById(Integer id) throws NotFoundException;

    Author insertAuthor(AuthorRequest authorRequest);
    void updateAuthor(Integer id, AuthorRequest authorRequest);
    void deleteAuthor(Integer id);

}
