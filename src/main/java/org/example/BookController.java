package org.example;

import org.example.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book")
    public String add() {

        Publisher publisher = new Publisher();
        publisher.setName("Nazwa");

        Book book = new Book();
        book.setTitle("Ania z zielonego wzgorza 2");
        book.setDescription("O ani");
        book.setRating(10);
        book.setPublisher(publisher);

        bookRepository.save(book);

        return book.toString();
    }

    @GetMapping("/book/{id}")
    public String get(@PathVariable BigInteger id) {

        System.out.println("Test");
        return bookRepository.getOne(id).toString();
    }

    @GetMapping("/book")
    public String findAll(@RequestParam(required = false) Integer rating,
                          @RequestParam(required = false) String title) {

        List<Book> books;
        if (rating != null) {
            books = bookRepository.findAllByRating(rating);
        } else if(title != null){
            books = bookRepository.findByTitle(title);
        } else {
            books = bookRepository.findAll();
        }
        return books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(","));
    }

}
