package com.amycohen.day18_poll.controllers;

import com.amycohen.day18_poll.model.Poll;
import com.amycohen.day18_poll.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class PollController {
    @Autowired
    PollRepository pollRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<Poll> getAll() {
        List<Poll> questions = pollRepository.findAll();
        Collections.sort(questions);

        return questions;
    }

    @PostMapping("/")
    public String create(
         @RequestParam String question
    ) {
        int upvotes = 0;
        int downvotes = 0;
        int summedvotes = 0;
        String subject = "";
        Poll pollQuestion = new Poll(question, upvotes, downvotes, summedvotes);
        pollQuestion = pollRepository.save(pollQuestion);
        return "redirect:/";
    }

    @GetMapping("/{id}/upvote")
    public String upvote(
            @PathVariable("id") long id
    ) {
        Optional optional = pollRepository.findById(id);
        Poll pollQuestion = (Poll) optional.get();
        if (pollQuestion != null) {
            pollQuestion.upvotes++;
            pollQuestion.summedvotes = pollQuestion.upvotes - pollQuestion.downvotes;
            pollRepository.save(pollQuestion);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/downvote")
    public String downvote(
            @PathVariable("id") long id
    ) {
        Optional optional = pollRepository.findById(id);
        Poll pollQuestion = (Poll) optional.get();
        if (pollQuestion != null) {
            pollQuestion.downvotes++;
            pollQuestion.summedvotes = pollQuestion.upvotes - pollQuestion.downvotes;
            pollRepository.save(pollQuestion);
        }
        return "redirect:/";
    }
}
