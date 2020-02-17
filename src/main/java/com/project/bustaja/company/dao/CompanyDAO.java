package com.project.bustaja.company.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void insertCompany(CompanyVO vo) {
		String sql = "insert into company(companyCode, companyName) values(?,?)";
		
		System.out.println(vo.getCompanyCode() + "  kfjdsklfjkdsl   " + vo.getCompanyName() );
		jdbcTemplate.update(sql, vo.getCompanyCode(), vo.getCompanyName());
		
	}

	public List<CompanyVO> listCompany(int page, int limit) {
		List<CompanyVO> result = null;
		String sql = "select * from (select rownum as listNum, imsi.* from (( select * from company) imsi)) where listNum >= ? and listNum <= ?";
		Object[] args = {page,  limit};
		result = jdbcTemplate.query(sql, args, new CompanyRowMapper());
//		result = jdbcTemplate.query(sql, new CompanyRowMapper());
		System.out.println(result.get(0));
		return result;
	}

	public CompanyVO getCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delCompany(long code) {
		String sql ="delete from company where companyCode=?";
		jdbcTemplate.update(sql, code);
		
	}

	public void updateCompany(CompanyVO vo) {
		// TODO Auto-generated method stub
		
	}

	public int getCount() {
		String sql = "select count(*) from company";
		return jdbcTemplate.queryForInt(sql);
	}
	
	
	
}
