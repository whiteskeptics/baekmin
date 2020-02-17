package com.project.bustaja.company.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CompanyRowMapper implements RowMapper<CompanyVO> {

	@Override
	public CompanyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompanyVO vo = new CompanyVO();
		vo.setCompanyCode(rs.getLong("CompanyCode"));
		vo.setCompanyName(rs.getString("companyName"));
		return vo;
	}

	

}
