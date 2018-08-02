package com.app.server.controllers;

import com.app.server.model.Question;
import com.app.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionRepository QuestionRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<Question> getAll() {
        List<Question> questions = QuestionRepository.findAll();
        Collections.sort(questions);
        return questions;
    }

    @PostMapping("/")
    @ResponseBody
    public Question create(
            @RequestParam String title,
            @RequestParam String body
    ) {
        Question Q = new Question(title, body);
        Q = QuestionRepository.save(Q);
        return Q;
    }

    @GetMapping("/{id}/upvote")
    public String upvote(
            @PathVariable("id") long id
    ) {
        Optional optional = QuestionRepository.findById(id);
        Question Q = (Question) optional.get();
        if (Q != null) {
            Q.votes++;
            QuestionRepository.save(Q);
        }
        return "redirect:/";
    }
}