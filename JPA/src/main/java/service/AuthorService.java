package service;

import model.Author;
import model.Book;

import java.util.List;

/**
 * Created by Habib, on 19/11/2020
 */
public interface AuthorService {
    void saveAuthor(Author author);

    List<Author> findAuthorById(Long id);

    int countOfAuthor();
}
