package org.levi.demomybatispp.controller;

import org.levi.demomybatispp.model.ApiResponse;
import org.levi.demomybatispp.model.Book;
import org.levi.demomybatispp.model.BookRequest;
import org.levi.demomybatispp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBook(){
        List<Book> books = bookService.getAllBook();

        ApiResponse<List<Book>> response = new ApiResponse<>(
                "Successfully fetched books",
                HttpStatus.OK,
                200,
                books
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> insertBook(@RequestBody BookRequest bookRequest){
        Book book = bookService.insertBook(bookRequest);

        ApiResponse<Book> response = new ApiResponse<>(
                "Successfully fetched books",
                HttpStatus.CREATED,
                201,
                book
        );

        return ResponseEntity.ok(response);
    }

}
