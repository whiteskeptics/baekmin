package com.project.bustaja.userview.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class UserViewRowMapper implements RowMapper<UserViewVO>{

	@Override
	public UserViewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserViewVO vo = new UserViewVO();
		vo.setRouteNum(rs.getInt("routeNum"));
		vo.setStartTime(rs.getString("startTime"));
		vo.setSeatClass(rs.getInt("seatClass"));
		vo.setCompanyName(rs.getString("companyName"));
		vo.setCompanyCode(rs.getLong("companyCode"));
		vo.setSeatName(rs.getString("seatName"));
		vo.setSeatCnt(rs.getInt("seatCnt"));
		vo.setBusPrice(rs.getLong("busPrice"));
		vo.setDistance(rs.getLong("distance"));
		vo.setRunTime(rs.getString("runTime"));
		return vo;
		
	}

	

}
