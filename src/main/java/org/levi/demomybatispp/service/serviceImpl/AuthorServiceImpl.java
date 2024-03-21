package org.levi.demomybatispp.service.serviceImpl;

import org.apache.ibatis.javassist.NotFoundException;
import org.levi.demomybatispp.model.Author;
import org.levi.demomybatispp.model.AuthorRequest;
import org.levi.demomybatispp.repository.AuthorRepository;
import org.levi.demomybatispp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAuthor();
    }

    @Override
    public Author getAuthorById(Integer id) throws NotFoundException {
        if (authorRepository.findAuthorById(id) == null){
            throw new NotFoundException("Author Does not exist!");
        }
        return authorRepository.findAuthorById(id);
    }

    @Override
    public Author insertAuthor(AuthorRequest authorRequest) {
        return authorRepository.insertAuthor(authorRequest);
    }

    @Override
    public void updateAuthor(Integer id, AuthorRequest authorRequest) {
        authorRepository.updateAuthor(id, authorRequest);
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.deleteAuthor(id);
    }
}
