package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDateTime;

public class NoticeBoardServiceRun {
    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("root-context.xml");

        NoticeBoardService noticeBoardService = factory.getBean("noticeBoardServiceImpl", NoticeBoardService.class);

        BoardDto boardDto = new BoardDto();

        boardDto.setTitle("공지게시판10");
        boardDto.setContent("공지게시판10의 내용물");
        boardDto.setWRITER_ID(1);

        noticeBoardService.insertNoticeBoard(boardDto);

        noticeBoardService.getNoticeBoards().forEach(board -> {
            System.out.println(board);
        });

        System.out.println(noticeBoardService.getNoticeBoard(7));

        BoardDto twoNoticeBoardDto = new BoardDto();
        twoNoticeBoardDto.setId(9);
        twoNoticeBoardDto.setTitle("공지게시판9 수정");
        twoNoticeBoardDto.setContent("공지게시판9 내용물 수정");
        twoNoticeBoardDto.setModdate(LocalDateTime.now());

        noticeBoardService.updateNoticeBoard(twoNoticeBoardDto);

        noticeBoardService.deleteNoticeBoard(3);
    }
}
