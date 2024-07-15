package com.bit.springboard.dao;

import com.bit.springboard.dto.MemberDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object): 데이터베이스에 직접 접근해서 쿼리를 실행하는 클래스
@Repository
//public class MemberDao extends JdbcDaoSupport {
public class MemberDao{
//    @Autowired
//    public void setSupserDataSource(DataSource dataSource) {
//        super.setDataSource(dataSource);
//    }
//    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    public MemberDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    private SqlSessionTemplate mybtis;

    @Autowired
    public MemberDao(SqlSessionTemplate sqlSessionTemplate) {
        this.mybtis = sqlSessionTemplate;
    }


    public void join(MemberDto memberDto){
        // MemeberDto에 담겨있는 내용을 MEMBER 테이블에 insert
        System.out.println("MemberDao의 join 메소드 실행");

//        jdbcTemplate.update(JOIN,
//                memberDto.getUsername(),
//                memberDto.getPassword(),
//                memberDto.getEmail(),
//                memberDto.getNickname(),
//                memberDto.getTel()
//        );
        mybtis.insert("MemberDao.join", memberDto);

        System.out.println("MemberDao의 join 메소드 실행 종료");
    }

    public List<MemberDto> getMembers(){
        System.out.println("MemberDao의 getMembers 메소드 실행");

        // 리턴할 MemberDto 목록
        List<MemberDto> memberDtoList = new ArrayList<>();

//        memberDtoList = jdbcTemplate.query(GET_MEMBERS, new MemberRowMapper());
        memberDtoList = mybtis.selectList("MemberDao.getMembers");

        return memberDtoList;
    }

    public MemberDto getMemberByUsername(String username){
        System.out.println("MemberDao의 getMemberByUsername 메소드 실행");

        MemberDto returnMemberDto = new MemberDto();

//        Object[] args = {username};
//        returnMemberDto = jdbcTemplate.queryForObject(GET_MEMBER_BY_USERNAME, args, new MemberRowMapper());

        returnMemberDto = mybtis.selectOne("MemberDao.getMemberByUsername", username);

        return returnMemberDto;
    }
}
