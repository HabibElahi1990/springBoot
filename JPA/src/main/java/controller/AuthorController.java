package controller;

import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AuthorService;

import java.util.HashSet;

/**
 * Created by Habib, on 20/11/2020
 */
@Controller
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/saveAuthor")
    public String saveAuthor(@RequestBody Author author, Model model) {
        Author newAuthor = Author.builder().firstName(author.getFirstName()).lastName(author.getLastName()).bookSet(new HashSet<>()).build();
        Book book = new Book("Spring boot JPA", "123456789");
        newAuthor.getBookSet().add(book);
        Book bo = new Book("Spring MVC ", "987654321");
        newAuthor.getBookSet().add(bo);
        authorService.saveAuthor(newAuthor);
        model.addAttribute("message", "insert Book is successful");
        return "views/showMessage";
    }

    @RequestMapping("/getCountAuthor")
    public String getCountAuthor(Model model) {
        model.addAttribute("message", "count of Author is " + authorService.countOfAuthor());
        return "views/showMessage";
    }

}
