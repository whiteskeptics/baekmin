package com.project.bustaja.terminal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class TerminalRowMapper implements RowMapper<TerminalVO> {

	@Override
	public TerminalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TerminalVO vo = new TerminalVO();
		vo.setTermCode(rs.getString("termCode"));
		vo.setTermName(rs.getString("termName"));
		vo.setBusType(rs.getString("busType"));
		vo.setAddress(rs.getString("address"));
		vo.setPhone(rs.getString("phone"));
		vo.setHomepage(rs.getString("homepage"));
		return vo;
	}

}
