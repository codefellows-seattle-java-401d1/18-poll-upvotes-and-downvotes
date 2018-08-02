package com.example.demo.controllers;


import com.example.demo.model.Votify;
import com.example.demo.repositories.VotifyRepository;
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
    VotifyRepository votifyRepository;

    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("hit home controller");

        Date date = new Date();
        model.addAttribute("currenttime", date.toString());

        List<Votify> crew = votifyRepository.findAll();
        Collections.sort(crew);
        model.addAttribute("crew", crew);

        return "index";
    }
}
