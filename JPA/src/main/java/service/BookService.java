package service;

import model.Author;
import model.Book;

/**
 * Created by Habib, on 19/11/2020
 */
public interface BookService {
    void SaveBook(Book book );

    int countOfBook();
}
