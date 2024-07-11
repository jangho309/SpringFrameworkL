package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;

import java.util.List;

public interface BoardService {
    void post(BoardDto boardDto);

    void modify(BoardDto boardDto);

    void delete(int id);

    List<BoardDto> getBoardList();

    List<BoardDto> getBoardNickNameList();

    BoardDto getBoard(int id);
}
