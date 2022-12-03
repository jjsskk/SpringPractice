package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository //전역변수로 등록(xml에 bean으로 등록해도 같은기능)
public class BoardDAO {
	
	@Autowired
	JdbcTemplate template;

	private final String BOARD_INSERT = "insert into BOARD (title, writer, content,category) values (?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=?, category=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");

		return template.update(BOARD_INSERT,new Object[]{vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getCategory()});
	}

	// 글 삭제
	public int deleteBoard(int id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		return template.update(BOARD_DELETE,new Object[]{id});
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");

		return template.update(BOARD_UPDATE,new Object[]{vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getCategory(),vo.getSeq()});
	}	
	
	public BoardVO getBoard(int seq) {

		System.out.println("===> JDBC로 getBoard() 기능 처리");

		return template.queryForObject(BOARD_GET, new Object[] {seq},new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	
	public List<BoardVO> getBoardList(){
		System.out.println("===> JDBC로 getBoardList() 기능 처리");

		return template.query(BOARD_LIST, new RowMapper<BoardVO>(){
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO data = new BoardVO();
			data.setSeq(rs.getInt("seq"));
			data.setTitle(rs.getString("title"));
			data.setWriter(rs.getString("writer"));
			data.setContent(rs.getString("content"));
			data.setCategory(rs.getString("category"));
			data.setRegdate(rs.getDate("regdate"));
//				System.out.println(data.getSeq()+data.getContent());
			return data;
			}
		});
	}
}
