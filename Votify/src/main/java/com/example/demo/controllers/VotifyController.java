package com.example.demo.controllers;

import com.example.demo.model.Votify;
import com.example.demo.repositories.VotifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/crew")
public class VotifyController {
    @Autowired
    VotifyRepository votifyRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<Votify> getAll() {
        List<Votify> votifies = votifyRepository.findAll();
        Collections.sort(votifies);
        return votifies;
    }

    @PostMapping("/")
    @ResponseBody
    public Votify create(
         @RequestParam String content,
         @RequestParam int upvotes,
         @RequestParam int downvotes
    ) {
        Votify item = new Votify(content, upvotes, downvotes);
        item = votifyRepository.save(item);
        return item;
    }

    @GetMapping("/{id}/upvote")
    public String upvote(
            @PathVariable("id") long id
    ) {
        Optional optional = votifyRepository.findById(id);
        Votify item = (Votify) optional.get();
        if (item != null) {
            item.upvotes++;
            votifyRepository.save(item);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/downvote")
    public String downvote(
            @PathVariable("id") long id
    ) {
        Optional optional = votifyRepository.findById(id);
        Votify item = (Votify) optional.get();
        if (item != null) {
            item.downvotes++;
            votifyRepository.save(item);
        }
        return "redirect:/";
    }
}
