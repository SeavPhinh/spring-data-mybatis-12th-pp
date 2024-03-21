package org.levi.demomybatispp.service;

import org.levi.demomybatispp.model.Book;
import org.levi.demomybatispp.model.BookRequest;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    Book insertBook(BookRequest bookRequest);
}
