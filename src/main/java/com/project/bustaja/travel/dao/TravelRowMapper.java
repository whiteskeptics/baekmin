package com.project.bustaja.travel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.bustaja.company.dao.CompanyVO;

public class TravelRowMapper implements RowMapper<TravelVO>{

	@Override
	public TravelVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TravelVO vo = new TravelVO();
		vo.setTravelNum(rs.getInt("travelNum"));
		vo.setDeparture(rs.getString("departure"));
		vo.setDestination(rs.getString("destination"));
		vo.setRunTime(rs.getString("runTime"));
		vo.setDistance(rs.getInt("distance"));
		vo.setFee(rs.getInt("fee"));
		vo.setFlatform(rs.getInt("flatform"));
		return vo;
	}

}
