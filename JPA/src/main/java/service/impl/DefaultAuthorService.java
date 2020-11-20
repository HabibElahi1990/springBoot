package service.impl;

import model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AuthorRepository;
import repository.BookRepository;
import service.AuthorService;

import java.util.List;

/**
 * Created by Habib, on 19/11/2020
 */
@Service
public class DefaultAuthorService implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public DefaultAuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    @Transactional
    public void saveAuthor(Author author) {
        author.getBookSet().forEach(bookRepository::save);
        bookRepository.flush();
        authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAuthorById(Long id) {
        return authorRepository.findAuthorById(id);
    }

    @Override
    public int countOfAuthor() {
        return (int) authorRepository.count();
    }
}
