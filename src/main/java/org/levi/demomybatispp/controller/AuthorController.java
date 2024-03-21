package org.levi.demomybatispp.controller;

import org.apache.ibatis.javassist.NotFoundException;
import org.levi.demomybatispp.model.ApiResponse;
import org.levi.demomybatispp.model.Author;
import org.levi.demomybatispp.model.AuthorRequest;
import org.levi.demomybatispp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthor(){
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer id) throws NotFoundException {
        Author author = authorService.getAuthorById(id);
        ApiResponse<Author> response = new ApiResponse<>(
                "Successfully fetched author",
                HttpStatus.OK,
                200,
                author
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> insertAuthor(@RequestBody AuthorRequest authorRequest){
        Author author = authorService.insertAuthor(authorRequest);
        ApiResponse<Author> response = new ApiResponse<>(
                "Successfully inserted author",
                HttpStatus.OK,
                200,
                author
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody AuthorRequest authorRequest){
        authorService.updateAuthor(id, authorRequest);
        ApiResponse<Author> response = new ApiResponse<>(
                "Successfully updated author",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthor(id);
        ApiResponse<Author> response = new ApiResponse<>(
                "Successfully deleted author",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }




}
