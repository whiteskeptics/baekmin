package com.project.bustaja.time.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.bustaja.company.dao.CompanyRowMapper;
import com.project.bustaja.company.dao.CompanyVO;

@Repository
public class TimeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertTime(TimeVO vo) {
		String sql = "insert into bustimeinfo(routeNum, company,seatClass,startTime,busNum) values(?,?,?,?,?)";
		
//		System.out.println(vo.getCompanyCode() + "  kfjdsklfjkdsl   " + vo.getCompanyName() );
		jdbcTemplate.update(sql, vo.getRouteNum(), vo.getCompany(), vo.getSeatClass(), vo.getStartTime(), vo.getBusNum());
		
	}

	public List<TimeVO> listTime(int page, int limit) {
		List<TimeVO> result = null;
		String sql = "select * from (select rownum as listNum, imsi.* from (( select * from bustimeinfo) imsi)) where listNum >= ? and listNum <= ?";
		Object[] args = {page,  limit};
		result = jdbcTemplate.query(sql, args, new TimeRowMapper());
//		result = jdbcTemplate.query(sql, new CompanyRowMapper());
		System.out.println(result.get(0));
		return result;
	}

	public TimeVO getTime() {
		
		return null;
	}

	public void delTime(int busNum) {
		String sql ="delete from bustimeinfo where busNum=?";
		jdbcTemplate.update(sql, busNum);
		
	}

	public void updateTime(TimeVO vo) {
		
		
	}

	public int getCount() {
		String sql = "select count(*) from bustimeinfo";
		return jdbcTemplate.queryForInt(sql);
	}
	
	
}
