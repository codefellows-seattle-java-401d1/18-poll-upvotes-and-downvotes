package com.lab.brandon.controllers;

import com.lab.brandon.model.Poll;
import com.lab.brandon.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PollRepository pollRepository;

    @RequestMapping("/")
    public String homePage (Model model) {
        List<Poll> poll = pollRepository.findAll();
        Collections.sort(poll);
        model.addAttribute("poll", poll);

        return "index";
    }
}
