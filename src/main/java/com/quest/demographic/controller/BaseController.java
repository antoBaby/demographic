package com.quest.demographic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String initialPage() {
        return "index";
    }


    @GetMapping("/addnew")
    public String pageLoader(Model model) {
        return "recordform";
    }

}
