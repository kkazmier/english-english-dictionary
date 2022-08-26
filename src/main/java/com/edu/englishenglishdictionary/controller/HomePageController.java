package com.edu.englishenglishdictionary.controller;

import com.edu.englishenglishdictionary.model.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home", "/"})
public class HomePageController {
    @GetMapping()
    public String home(Model model) {
        model.addAttribute("word", new Word());
        return "home";
    }
}
