package com.project.bustaja.terminal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TerminalDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertTerminal(TerminalVO vo) {
		String sql = "insert into terminal(termCode, termName, busType, address, phone, homepage) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, vo.getTermCode(), vo.getTermName(), vo.getBusType(), vo.getAddress(), vo.getPhone(), vo.getHomepage());
	}
	
	public List<TerminalVO> listTerminal(int page, int limit){
		List<TerminalVO> result = null;
		String sql = "select * from (select rownum as listNum, imsi.* from (( select * from terminal) imsi)) where listNum >= ? and listNum <= ?";
		Object[] args = {page, limit};
		result = jdbcTemplate.query(sql, args, new TerminalRowMapper());
		System.out.println(result.get(0));
		return result;
	}
	
	public List<TerminalVO> getTerminal() {
		List<TerminalVO> result = null;
		String sql = "select * from terminal";
		result = jdbcTemplate.query(sql, new TerminalRowMapper());
		System.out.println(result.get(0));
		return result;
	}
	
	public void delTerminal(String code) {
		String sql = "delete from terminal where termCode = ?";
		jdbcTemplate.update(sql, code);
	}
	
	public void updateTerminal(TerminalVO vo) {
		
	}
	
	public int getCount() {
		String sql = "select count(*) from terminal";
		return jdbcTemplate.queryForInt(sql);
	}


	
}
