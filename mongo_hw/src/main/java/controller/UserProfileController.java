package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import java.math.BigInteger;

@Controller
public class UserProfileController {

    private StudentService studentService;

    @Autowired
    public UserProfileController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/user/{id}")
    public ModelAndView getUser(@PathVariable BigInteger id) {
        return new ModelAndView("user_profile", "user", studentService.getUserById(id));
    }

    @RequestMapping("/minscore")
    public void deleteMin() {
        studentService.deleteMinScore();
    }
}
