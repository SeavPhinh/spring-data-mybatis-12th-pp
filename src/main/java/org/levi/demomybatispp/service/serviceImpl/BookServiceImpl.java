package org.levi.demomybatispp.service.serviceImpl;

import org.levi.demomybatispp.model.Book;
import org.levi.demomybatispp.model.BookRequest;
import org.levi.demomybatispp.repository.BookRepository;
import org.levi.demomybatispp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public Book insertBook(BookRequest bookRequest) {
        Integer bookId = bookRepository.saveBook(bookRequest);
        for (Integer categoryId : bookRequest.getCategoryId()){
            bookRepository.insertIntoBookCategory(bookId,categoryId);
        }
        return bookRepository.findBookById(bookId);
    }
}
