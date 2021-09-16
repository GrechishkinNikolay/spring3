package ru.grechishkin.spring3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondContr {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
