package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.Creteria;

import java.util.List;
import java.util.Map;

public interface BoardService {
    void post(BoardDto boardDto);

    void modify(BoardDto boardDto);

    void delete(BoardDto boardDto);

    List<BoardDto> getBoardList(Map<String, String> searchMap, Creteria cri);

    BoardDto getBoard(int id);

    void updateBoardCnt(int id);

    public int getBoardTotalCnt(Map<String, String> searchMap);
}
