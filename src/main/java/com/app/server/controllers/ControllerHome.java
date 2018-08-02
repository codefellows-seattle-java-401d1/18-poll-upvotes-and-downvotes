package com.app.server.controllers;

import com.app.server.model.Question;
import com.app.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerHome {
    @Autowired
    QuestionRepository QuestionRepository;

    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("hit home controller");

        Date date = new Date();
        model.addAttribute("currenttime", date.toString());

        List<Question> questions = QuestionRepository.findAll();
        Collections.sort(questions);
        model.addAttribute("questions", questions);

        return "index";
    }
}