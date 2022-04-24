package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/form/student", method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String handle(Student student){
        logger.info(student.toString());
        return "success";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Fishing", "Boxing");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("SQL", "Spring", "NoSQL");
    }


}
