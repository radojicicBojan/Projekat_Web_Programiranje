package com.example.projekatfc.controller;

import com.example.projekatfc.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class TreningController {

    @Autowired
    private TreningService treningService;

    @GetMapping("/")
    public String welcome() {return "homepage.html";}


}
