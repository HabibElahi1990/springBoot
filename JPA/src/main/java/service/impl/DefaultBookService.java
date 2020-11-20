package service.impl;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AuthorRepository;
import repository.BookRepository;
import service.BookService;

/**
 * Created by Habib, on 19/11/2020
 */

@Service
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public DefaultBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    @Transactional
    public void SaveBook(Book book) {
        authorRepository.save(book.getAuthor());
        authorRepository.flush();
        bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public int countOfBook() {
        return (int) bookRepository.count();
    }
}
