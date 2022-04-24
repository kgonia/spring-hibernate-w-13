package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping(value = "/form/person", method = RequestMethod.GET)
    public String getFrom() {
        logger.info("returning view with form");
        return "person";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String savePerson(Person person){
        personDao.save(person);
        return "success";
    }
}
