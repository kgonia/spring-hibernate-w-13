package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping("/form")
public class BookFormController {

    private final BookDao bookDao;

    private final PublisherDao publisherDao;

    private static final Logger logger = LoggerFactory.getLogger(BookFormController.class);

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String handle(Book book){
        bookDao.save(book);
        return "success";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }
}
