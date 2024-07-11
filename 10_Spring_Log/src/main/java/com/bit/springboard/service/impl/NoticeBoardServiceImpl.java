package com.bit.springboard.service.impl;

import com.bit.springboard.common.LogConsoleV2;
import com.bit.springboard.dao.NoticeBoardDao;
import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.NoticeBoardDto;
import com.bit.springboard.service.NoticeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
    private NoticeBoardDao noticeBoardDao;
    //    private LogConsole logConsole;
    private LogConsoleV2 logConsoleV2;

    @Autowired
    public NoticeBoardServiceImpl(NoticeBoardDao noticeBoardDao) {
        this.logConsoleV2 = new LogConsoleV2();
        this.noticeBoardDao = noticeBoardDao;
    }

    @Override
    public void newNoticeBoard(BoardDto boardDto) {
        logConsoleV2.consoleLogPlus();
        noticeBoardDao.newNoticeBoard(boardDto);
    }

    @Override
    public List<BoardDto> getNoticeBoards() {
        logConsoleV2.consoleLogPlus();
        return noticeBoardDao.getNoticeBoardList();
    }

    @Override
    public NoticeBoardDto getNoticeBoard(NoticeBoardDto noticeBoardDto) {
        logConsoleV2.consoleLogPlus();
        return noticeBoardDao.getNoticeBoard(noticeBoardDto);
    }

    @Override
    public void deleteNoticeBoard(int noticeBoardId) {
        logConsoleV2.consoleLogPlus();
        noticeBoardDao.deleteNoticeBoard(noticeBoardId);
    }

    @Override
    public void updateNoticeBoard(BoardDto boardDto) {
        logConsoleV2.consoleLogPlus();
        noticeBoardDao.updateNoticeBoard(boardDto);
    }
}
