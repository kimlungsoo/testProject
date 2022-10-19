package com.test.board.controller;

import com.test.board.entity.Board;
import com.test.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/board/list")
    public String boardList(Model model, @PageableDefault(page = 0, size = 3, sort = "id") Pageable pageable) {

        Page<Board> list = boardService.boardList(pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = Math.min(nowPage +5 , list.getTotalPages());
        model.addAttribute("list",boardService.boardList(pageable));
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(Model model, Integer id){

        model.addAttribute("board",boardService.boardView(id));
        return "boardView";
    }

    @GetMapping("test-api")
    @ResponseBody // 바디 부분에 내가 직접 넣어 주겠다.
    public TestName test(@RequestParam("name") String name) {
        TestName testName = new TestName();
        System.out.println(name);
        testName.setName(name);
        return testName;

    }
        static class TestName {
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            private String name;

        }

}
