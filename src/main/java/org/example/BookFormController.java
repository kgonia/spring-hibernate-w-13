package org.example;

import org.example.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/form")
public class BookFormController {

    private final BookRepository bookRepository;

    private final PublisherDao publisherDao;

    private static final Logger logger = LoggerFactory.getLogger(BookFormController.class);

    public BookFormController(BookRepository bookRepository, PublisherDao publisherDao) {
        this.bookRepository = bookRepository;
        this.publisherDao = publisherDao;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String handle(@Valid Book book, BindingResult bindingResult){
        // sprawdzamy czy sa błędy po walidacji
        if(bindingResult.hasErrors()){
            logger.error("ksiazka ma nieprawidlowe dane");
            return "book";
        }
        bookRepository.save(book);
        // przekierowujemy na adres /form/books co spowoduje wyswietlenei listy ksiazek
        return "redirect:/form/books";
    }

    // dodajemy endpoint który
    @GetMapping(value = "/books")
    public String getAll(Model model){
        // pobieramy listę ksiązek
        List<Book> books = bookRepository.findAll();
        // dodajemy ksiazki do modelu aby byly dostepne dla widoku
        model.addAttribute("books", books);
        // zwracamy nazwe widoku ktory zostanie wyswietlony
        return "books";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }
}
