package com.amycohen.day18_poll.controllers;

import com.amycohen.day18_poll.model.Poll;
import com.amycohen.day18_poll.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerHome {
    @Autowired
    PollRepository pollRepository;

    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("hit home controller");

        Date date = new Date();
        model.addAttribute("currenttime", date.toString());

        List<Poll> questions = pollRepository.findAll();
        Collections.sort(questions);
        model.addAttribute("questions", questions);

        return "index";
    }
}
