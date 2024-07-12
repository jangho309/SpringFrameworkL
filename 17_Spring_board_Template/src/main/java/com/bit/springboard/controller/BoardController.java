package com.bit.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("free-list.do")
    public String freeListView(){
        return "board/free-list";
    }

    @GetMapping("board-list.do")
    public String boardListView(){
        return "board/board-list";
    }
}
