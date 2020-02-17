package com.project.bustaja.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO vo = new UserVO();
		vo.setCid(rs.getString("cid"));
		vo.setCpw(rs.getString("cpw"));
		vo.setCname(rs.getString("cname"));
		vo.setCphone(rs.getString("cphone"));
		vo.setLev(rs.getInt("lev"));
		return vo;
	}

}
