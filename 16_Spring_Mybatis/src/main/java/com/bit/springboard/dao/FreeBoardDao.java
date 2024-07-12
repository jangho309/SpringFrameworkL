package com.bit.springboard.dao;

import com.bit.springboard.dto.BoardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// JDBC Template 사용방식 2
// JdbcTemplate를 필드로 선언하고 의존성을 주입받아서 사용하는 방식
@Repository
public class FreeBoardDao {
    private SqlSessionTemplate mybaits;

    @Autowired
    public FreeBoardDao(SqlSessionTemplate sqlSessionTemplate) {
        this.mybaits = sqlSessionTemplate;
    }

    private final String GET_BOARD_LIST = "SELECT FB.ID" +
            "                                   , FB.TITLE" +
            "                                   , FB.CONTENT" +
            "                                   , FB.WRITER_ID" +
            "                                   , M.NICKNAME" +
            "                                   , FB.REGDATE" +
            "                                   , FB.MODDATE" +
            "                                   , FB.CNT" +
            "                                FROM FREEBOARD FB" +
            "                                JOIN MEMBER M" +
            "                                  ON FB.WRITER_ID = M.ID";

    private final String GET_BOARD_NICKNAME_LIST = "SELECT FB.ID" +
            "                                            , FB.TITLE" +
            "                                            , FB.CONTENT" +
            "                                            , FB.WRITER_ID" +
            "                                            , M.NICKNAME" +
            "                                            , FB.REGDATE" +
            "                                            , FB.MODDATE" +
            "                                            , FB.CNT" +
            "                                         FROM FREEBOARD FB" +
            "                                         JOIN MEMBER M" +
            "                                           ON FB.WRITER_ID = M.ID";

    // 게시글 삭제
    private final String DELETE = "DELETE FROM FREEBOARD" +
            "                       WHERE ID = ?" ;

    // 특정 id의 게시글 하나만 조회
    private final String GET_BOARD = "SELECT FB.ID" +
            "                              , FB.TITLE" +
            "                              , FB.CONTENT" +
            "                              , FB.WRITER_ID" +
            "                              , M.NICKNAME" +
            "                              , FB.REGDATE" +
            "                              , FB.MODDATE" +
            "                              , FB.CNT" +
            "                           FROM FREEBOARD FB" +
            "                           JOIN MEMBER M" +
            "                             ON FB.WRITER_ID = M.ID" +
            "                          WHERE FB.ID = ?";

    public void post(BoardDto boardDto){
        System.out.println("FreeBoardDao의 post 메소드 실행");

        mybaits.insert(/*쿼리문의 호출은 Mapper.xml 파일의 namespace값.쿼리문의 id*/"FreeBoardDao.post", boardDto);

        System.out.println("FreeBoardDao의 post 메소드 실행 종료");
    }

    public void modify(BoardDto boardDto){
        System.out.println("FreeBoardDao의 modify 메소드 실행");

        mybaits.update("FreeBoardDao.modify", boardDto);

        System.out.println("FreeBoardDao의 modify 메소드 종료");
    }

    public List<BoardDto> getBoardList(){
        System.out.println("FreeBoardDao의 getBoardList 메소드 실행");

        List<BoardDto> boardList = new ArrayList<>();

        // SqlSessionTemplate의 selectList메소드 사용
        boardList = mybaits.selectList("FreeBoardDao.getBoardList");

        return boardList;
    }


    public void delete(int id){
        System.out.println("FreeBoardDao의 delete 메소드 실행");

        mybaits.delete("FreeBoardDao.delete", id);

        System.out.println("FreeBoardDao의 delete 메소드 실행 종료");
    }

    public BoardDto getBoard(int id){
        System.out.println("FreeBoardDao의 getBoard 메소드 실행");

        BoardDto boardDto = new BoardDto();

        // SqlSessionTemplate의 selectOne메소드 사용
        boardDto = mybaits.selectOne("FreeBoardDao.getBoard", id);

        return boardDto;
    }
}
