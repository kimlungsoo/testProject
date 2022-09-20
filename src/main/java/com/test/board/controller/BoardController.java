package com.test.board.controller;

import com.test.board.entity.Board;
import com.test.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/login")
    public String boardWriteForm(){

        return "login";
    }


    @PostMapping("/board/writedopro")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }
}
