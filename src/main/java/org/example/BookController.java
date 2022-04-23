package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping("/book")
    @ResponseBody
    public String add(){

        Publisher publisher = new Publisher();
        publisher.setName("Nazwa");

        Book book = new Book();
        book.setTitle("Ania z zielonego wzgorza 2");
        book.setDescription("O ani");
        book.setRating(10);
        book.setPublisher(publisher);

        bookDao.save(book);

        return book.toString();
    }

    @GetMapping("/book/{id}")
    public String get(@PathVariable BigInteger id){

        System.out.println("Test");
        return bookDao.get(id).toString();
    }
}
