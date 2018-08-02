package com.example.demo.controllers;

import com.example.demo.model.Question;
import com.example.demo.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<Question> getAll() {
        List<Question> question = questionRepository.findAll();
        Collections.sort(question);
        return question;
    }

    @PostMapping("/")
    @ResponseBody
    public Question create(
         @RequestParam String question
    ) {
        Question question1 = new Question(question);
        question1 = questionRepository.save(question1);
        return question1;
    }

    @GetMapping("/{id}/upvote")
    public String upVote(
            @PathVariable("id") long id
    ) {
        Optional optional = questionRepository.findById(id);
        Question question1 = (Question) optional.get();
        if (question1 != null) {
            question1.upVotes++;
            questionRepository.save(question1);
        }
        return "redirect:/";
    }


        // this is me attempting to make downvotes work.
    @GetMapping("/{id}/downvote")
    public String downVote(
            @PathVariable("id") long id
    ) {
        Optional optional = questionRepository.findById(id);
        Question question1 = (Question) optional.get();
        if (question1 != null) {
            // added another if statement to check if the vote is equal to or above 0. If it is, then It can be downvoted. This should prevent negative votes.
            if(question1.upVotes >= 0) {
                question1.downVotes--;
            }
            questionRepository.save(question1);
        }
        return "redirect:/";
    }
}
