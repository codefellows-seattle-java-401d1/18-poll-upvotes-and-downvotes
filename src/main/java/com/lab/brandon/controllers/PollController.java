package com.lab.brandon.controllers;

import com.lab.brandon.model.Poll;
import com.lab.brandon.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/poll")
public class PollController {
    @Autowired
    PollRepository pollRepository;

//    @RequestMapping("/")
//    @ResponseBody
//    public List<Poll> getAll () {
//        List<Poll> poll = pollRepository.findAll();
//        Collections.sort(poll);
//        return poll;
//    }

    @PostMapping("/")
    @ResponseBody
    public Poll create (@RequestParam String caption) {
        Poll poll = new Poll(caption);
        poll = pollRepository.save(poll);
        return poll;
    }

    @GetMapping("/{id}/upvote")
    public String upvote (@PathVariable("id") long id) {
        Optional optional = pollRepository.findById(id);
        Poll poll = (Poll) optional.get();
        if (poll != null) {
            poll.upvotes++;
            pollRepository.save(poll);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/downvote")
    public String downvote (@PathVariable("id") long id) {
        Optional optional = pollRepository.findById(id);
        Poll poll = (Poll) optional.get();
        if (poll != null) {
            poll.downvotes++;
            pollRepository.save(poll);
        }
        return "redirect:/";
    }
}
