package com.project.bustaja.time.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class TimeRowMapper implements RowMapper<TimeVO>{

	@Override
	public TimeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimeVO vo = new TimeVO();
		vo.setRouteNum(rs.getInt("routeNum"));
		vo.setCompany(rs.getInt("company"));
		vo.setSeatClass(rs.getInt("seatClass"));
		vo.setStartTime(rs.getString("startTime"));
		vo.setBusNum(rs.getInt("busNum"));
		return vo;
		
	}

	

}
