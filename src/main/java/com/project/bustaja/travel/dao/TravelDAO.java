package com.project.bustaja.travel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.bustaja.company.dao.CompanyRowMapper;
import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.terminal.dao.TerminalRowMapper;
import com.project.bustaja.terminal.dao.TerminalVO;

@Repository
public class TravelDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void insertTravel(TravelVO vo) {
		String sql = "insert into travelinfo(travelNum, departure, destination, runTime, distance, fee, flatform) values(?,?,?,?,?,?,?)";
		
		System.out.println(vo.getTravelNum() + "  kfjdsklfjkdsl   " + vo.getDeparture() );
		jdbcTemplate.update(sql, vo.getTravelNum(), vo.getDeparture(), vo.getDestination(), vo.getRunTime(), vo.getDistance(), vo.getFee(), vo.getFlatform());
		
	}

	
	public List<TravelVO> listTravel(int page, int limit) {
		List<TravelVO> result = null;
		String sql = "select * from (select rownum as listNum, imsi.* from (( select * from travelinfo) imsi)) where listNum >= ? and listNum <= ?";
		Object[] args = {page,  limit};
		result = jdbcTemplate.query(sql, args, new TravelRowMapper());
//		result = jdbcTemplate.query(sql, new CompanyRowMapper());
		System.out.println(result.get(0));
		return result;
	}

	
	public List<TravelVO> getTravel() {
		List<TravelVO> result = null;
		String sql = "select * from travelinfo";
		result = jdbcTemplate.query(sql, new TravelRowMapper());
		System.out.println(result.get(0));
		return result;
	}

	
	public void delTravel(int travelNum) {
		String sql ="delete from travelinfo where travelNum=?";
		jdbcTemplate.update(sql, travelNum);
	}

	
	public void updateTravel(TravelVO vo) {
		
	}

	
	public int getCount() {
		String sql = "select count(*) from travelinfo";
		return jdbcTemplate.queryForInt(sql);
	}

	
}
