package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.NoticeBoardDto;

import java.util.List;

public interface NoticeBoardService {
    public void newNoticeBoard(BoardDto boardDto);

    public List<BoardDto> getNoticeBoards();

    public NoticeBoardDto getNoticeBoard(NoticeBoardDto noticeBoardDto);

    public void deleteNoticeBoard(int noticeBoardId);

    public void updateNoticeBoard(BoardDto boardDto);
}
