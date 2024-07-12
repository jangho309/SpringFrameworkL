package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;

import java.util.List;

public interface NoticeBoardService {
    public void insertNoticeBoard(BoardDto boardDto);

    public List<BoardDto> getNoticeBoards();

    public BoardDto getNoticeBoard(int noticeBoardId);

    public void deleteNoticeBoard(int noticeBoardId);

    public void updateNoticeBoard(BoardDto boardDto);
}
