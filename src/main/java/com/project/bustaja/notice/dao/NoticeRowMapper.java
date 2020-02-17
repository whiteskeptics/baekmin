package com.project.bustaja.notice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class NoticeRowMapper implements RowMapper<NoticeVO> {

	@Override
	public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		NoticeVO vo = new NoticeVO();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setNcontents(rs.getString("ncontents"));
		vo.setNdate(rs.getDate("ndate"));
		vo.setNcount(rs.getLong("ncount"));
		
		return vo;
	}

}
