package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ValidationController {

    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    public String validateBook(Model model){
        Book book = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }

            model.addAttribute("violations", violations);

            List<Error> errorsList = violations
                    .stream()
                    .map(bookConstraintViolation
                            -> new Error(bookConstraintViolation.getPropertyPath().toString(), bookConstraintViolation.getMessage()))
                    .collect(Collectors.toList());

            model.addAttribute("errors", errorsList);
        } else {
            // save object
        }
        return "validateResult";
    }


}
