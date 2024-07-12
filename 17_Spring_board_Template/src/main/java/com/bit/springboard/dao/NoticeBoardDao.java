package com.bit.springboard.dao;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.NoticeBoardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
//public class NoticeBoardDao extends JdbcDaoSupport {
public class NoticeBoardDao {
//    @Autowired
//    public void setSuperDatSource(DataSource dataSource){
//        super.setDataSource(dataSource);
//    }
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public NoticeBoardDao(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
    private SqlSessionTemplate mybatis;

    @Autowired
    public NoticeBoardDao(SqlSessionTemplate sqlSessionTemplate) {
        this.mybatis = sqlSessionTemplate;
    }

    public void insertNoticeBoard(BoardDto boardDto) {
        System.out.println("newNoticeBoard의 newNoticeBoard 실행");

//        getJdbcTemplate().update(createNoticeBoard, boardDto.getTitle(), boardDto.getContent(), boardDto.getWRITER_ID());
//        jdbcTemplate.update(createNoticeBoard, boardDto.getTitle(), boardDto.getContent(), boardDto.getWRITER_ID());
        mybatis.insert("NoticeBoardDao.createNoticeBoard", boardDto);

        System.out.println("newNoticeBoard의 newNoticeBoard 실행 완료");
    }

    public List<BoardDto> getNoticeBoardList() {
        System.out.println("NoticeBoardDao의 getNoticeBoardList 실행");
        List<BoardDto> noticeBoardDtoList = new ArrayList<>();

//        noticeBoardDtoList = getJdbcTemplate().query(searchNoticeBoardList, new BoardRowMapper());
//        noticeBoardDtoList = jdbcTemplate.query(searchNoticeBoardList, new BoardRowMapper());
        noticeBoardDtoList = mybatis.selectList("NoticeBoardDao.getNoticeBoardList");

        return noticeBoardDtoList;
    }

    public BoardDto getNoticeBoard(int id) {
        System.out.println("NoticeBoardDao의 getNoticeBoard 실행");
        NoticeBoardDto rtnNoticeBoardDto = new NoticeBoardDto();

        BoardDto boardDto = new BoardDto();

//        Object[] args = {id};
//        boardDto = getJdbcTemplate().queryForObject(searchNoticeBoard, args, new BoardRowMapper());
//        boardDto = jdbcTemplate.queryForObject(searchNoticeBoard, args, new BoardRowMapper());
        boardDto = mybatis.selectOne("NoticeBoardDao.getNoticeBoard", id);

        return boardDto;
    }

    public void updateNoticeBoard(BoardDto boardDto) {
        System.out.println("NoticeBoardDao의 updateNoticeBoard 실행");

//        getJdbcTemplate().update(updateNoticeBoard, boardDto.getTitle(), boardDto.getContent(), boardDto.getModdate(), boardDto.getId());
//        jdbcTemplate.update(updateNoticeBoard, boardDto.getTitle(), boardDto.getContent(), boardDto.getModdate(), boardDto.getId());
        mybatis.update("NoticeBoardDao.updateNoticeBoard", boardDto);

        System.out.println("NoticeBoardDao의 updateNoticeBoard 실행 완료");
    }

    public void deleteNoticeBoard(int noticeBoardId) {
        System.out.println("NoticeBoardDao의 deleteNoticeBoard 실행");

//        getJdbcTemplate().update(deleteNoticeBoard, noticeBoardId);
//        jdbcTemplate.update(deleteNoticeBoard, noticeBoardId);
        mybatis.delete("NoticeBoardDao.deleteNoticeBoard", noticeBoardId);

        System.out.println("NoticeBoardDao의 deleteNoticeBoard 실행 완료");
    }
}
