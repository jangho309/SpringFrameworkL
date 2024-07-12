package com.bit.springboard.service.impl;

import com.bit.springboard.dao.NoticeBoardDao;
import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.service.NoticeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
    private NoticeBoardDao noticeBoardDao;

    @Autowired
    public NoticeBoardServiceImpl(NoticeBoardDao noticeBoardDao) {
        this.noticeBoardDao = noticeBoardDao;
    }

    @Override
    public void insertNoticeBoard(BoardDto boardDto) {
        noticeBoardDao.insertNoticeBoard(boardDto);
    }

    @Override
    public List<BoardDto> getNoticeBoards() {
        return noticeBoardDao.getNoticeBoardList();
    }

    @Override
    public BoardDto getNoticeBoard(int noticeBoardId) {
        return noticeBoardDao.getNoticeBoard(noticeBoardId);
    }

    @Override
    public void deleteNoticeBoard(int noticeBoardId) {
        noticeBoardDao.deleteNoticeBoard(noticeBoardId);
    }

    @Override
    public void updateNoticeBoard(BoardDto boardDto) {
        noticeBoardDao.updateNoticeBoard(boardDto);
    }
}
