package com.test.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/login")
    public String boardWriteForm(){

        return "login";
    }
}
