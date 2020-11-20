package controller;

import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BookRepository;
import service.AuthorService;
import service.BookService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Habib, on 05/11/2020
 */
@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService addAttribute;

    @Autowired
    public BookController(BookService bookService, AuthorService addAttribute) {
        this.bookService = bookService;
        this.addAttribute = addAttribute;
    }


    @RequestMapping("/getBookList/{authorId}")
    public String getBooks(@PathVariable Long authorId, Model model) {
        List<Author> authorList=addAttribute.findAuthorById(authorId);
        Set<Book> bookList=new HashSet<>();
        authorList.forEach(n->bookList.addAll(n.getBookSet()));

        model.addAttribute("bookList", bookList);
        return "views/list";
    }

    @RequestMapping("/saveBooks")
    public String saveAuthor(@RequestBody Book book,Model model) {
        Author newAuthor = Author.builder().firstName("mike").lastName("jordan").bookSet(new HashSet<>()).build();
        book.setAuthor(newAuthor);
        bookService.SaveBook(book);
        model.addAttribute("message", "insert Book is successful");
        return "views/showMessage";
    }

    @RequestMapping("/getCountBooks")
    public String getCountAuthor(Model model) {

        model.addAttribute("message", "count of Books is "+bookService.countOfBook());
        return "views/showMessage";
    }
}
