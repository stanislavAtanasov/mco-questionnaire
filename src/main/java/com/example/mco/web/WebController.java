package com.example.mco.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "/WEB-INF/views/index.html";
    }

}