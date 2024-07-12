package com.bit.springboard.dao;

import com.bit.springboard.common.JDBCUtil;
import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.NoticeBoardDto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NoticeBoardDaoJDBC {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    String createNoticeBoard = "INSERT INTO NOTICEBOARD(TITLE, CONTENT, WRITER_ID) VALUES(?, ?, ?)";

    String searchNoticeBoardList = "SELECT N.ID" +
            "                            , N.TITLE" +
            "                            , N.CONTENT" +
            "                            , N.WRITER_ID" +
            "                            , M.NICKNAME" +
            "                            , N.REGDATE" +
            "                            , N.MODDATE" +
            "                            , N.CNT" +
            "                         FROM NOTICEBOARD N" +
            "                         JOIN MEMBER M" +
            "                           ON N.WRITER_ID = M.ID";

    String searchNoticeBoard = "SELECT N.ID" +
            "                        , N.TITLE" +
            "                        , N.CONTENT" +
            "                        , N.WRITER_ID" +
            "                        , M.NICKNAME" +
            "                        , N.REGDATE" +
            "                        , N.MODDATE" +
            "                        , N.CNT" +
            "                     FROM NOTICEBOARD N" +
            "                     JOIN MEMBER M" +
            "                       ON N.WRITER_ID = M.ID" +
            "                    WHERE N.ID = ?";

    String updateNoticeBoard = "UPDATE NOTICEBOARD" +
            "                      SET TITLE = ?" +
            "                        , CONTENT = ?" +
            "                        , MODDATE = ?" +
            "                    WHERE ID = ?";

    String deleteNoticeBoard = "DELETE FROM NOTICEBOARD" +
            "                    WHERE ID = ?";

    public void newNoticeBoard(BoardDto boardDto) {
        System.out.println("newNoticeBoard의 newNoticeBoard 실행");
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(createNoticeBoard);

            pstmt.setString(1, boardDto.getTitle());
            pstmt.setString(2, boardDto.getContent());
            pstmt.setInt(3, boardDto.getWRITER_ID());

            pstmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(conn, pstmt);
        }
        System.out.println("newNoticeBoard의 newNoticeBoard 실행 완료");
    }

    public List<BoardDto> getNoticeBoardList() {
        System.out.println("NoticeBoardDao의 getNoticeBoardList 실행");
        List<BoardDto> noticeBoardDtoList = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();

            pstmt = conn.prepareStatement(searchNoticeBoardList);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDto noticeBoardDto = new BoardDto();
                noticeBoardDto.setId(rs.getInt("ID"));
                noticeBoardDto.setTitle(rs.getString("TITLE"));
                noticeBoardDto.setContent(rs.getString("CONTENT"));
                noticeBoardDto.setWRITER_ID(rs.getInt("WRITER_ID"));
                noticeBoardDto.setNickname(rs.getString("NICKNAME"));
                noticeBoardDto.setRegdate(rs.getTimestamp("REGDATE").toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
                noticeBoardDto.setModdate(rs.getTimestamp("MODDATE").toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
                noticeBoardDto.setCnt(rs.getInt("CNT"));

                noticeBoardDtoList.add(noticeBoardDto);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        System.out.println("NoticeBoardDao의 getNoticeBoardList 실행 완료");
        return noticeBoardDtoList;
    }

    public NoticeBoardDto getNoticeBoard(NoticeBoardDto noticeBoardDto) {
        System.out.println("NoticeBoardDao의 getNoticeBoard 실행");
        NoticeBoardDto rtnNoticeBoardDto = new NoticeBoardDto();

        try {
            conn = JDBCUtil.getConnection();

            pstmt = conn.prepareStatement(searchNoticeBoard);
            pstmt.setInt(1, noticeBoardDto.getId());

            rs = pstmt.executeQuery();
            if(rs.next()) {
                rtnNoticeBoardDto.setId(rs.getInt("ID"));
                rtnNoticeBoardDto.setTitle(rs.getString("TITLE"));
                rtnNoticeBoardDto.setContent(rs.getString("CONTENT"));
                rtnNoticeBoardDto.setWriter_id(rs.getInt("WRITER_ID"));
                rtnNoticeBoardDto.setRegdate(rs.getTimestamp("REGDATE").toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
                rtnNoticeBoardDto.setModdate(rs.getTimestamp("MODDATE").toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
                rtnNoticeBoardDto.setCnt(rs.getInt("CNT"));
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        System.out.println("NoticeBoardDao의 getNoticeBoard 실행 완료");
        return rtnNoticeBoardDto;
    }

    public void updateNoticeBoard(BoardDto boardDto) {
        System.out.println("NoticeBoardDao의 updateNoticeBoard 실행");
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(updateNoticeBoard);

            pstmt.setString(1, boardDto.getTitle());
            pstmt.setString(2, boardDto.getContent());
            pstmt.setString(3, String.valueOf(boardDto.getModdate()));
            pstmt.setInt(4, boardDto.getId());

            pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(conn, pstmt);
        }
        System.out.println("NoticeBoardDao의 updateNoticeBoard 실행 완료");
    }

    public void deleteNoticeBoard(int noticeBoardId) {
        System.out.println("NoticeBoardDao의 deleteNoticeBoard 실행");
        try {
            conn = JDBCUtil.getConnection();

            pstmt = conn.prepareStatement(deleteNoticeBoard);
            pstmt.setInt(1, noticeBoardId);

            pstmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            JDBCUtil.close(conn, pstmt);
        }

        System.out.println("NoticeBoardDao의 deleteNoticeBoard 실행 완료");
    }
}
