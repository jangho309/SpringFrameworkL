package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;

import java.util.List;

public interface BoardService {
    void post(BoardDto boardDto);

    void modify(BoardDto boardDto);

    void delete(BoardDto boardDto);

    List<BoardDto> getBoardList();

    BoardDto getBoard(int id);

    void updateBoardCnt(int id);
}
