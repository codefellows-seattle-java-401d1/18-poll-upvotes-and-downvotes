package com.lab.brandon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage (Model model) {
        Date date = new Date();

        model.addAttribute("currenttime", date.toString());

        return "index";
    }
}
