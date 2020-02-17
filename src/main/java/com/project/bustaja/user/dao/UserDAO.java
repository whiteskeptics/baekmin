package com.project.bustaja.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertUser(UserVO vo) {
		String sql = "insert into customer(cid, cpw, cname, cphone, lev) values(?,?,?,?,1)";
		System.out.println("id = " + vo.getCid()  + " pw = " + vo.getCpw() + " name = " + vo.getCname() + " phone " +  vo.getCphone() + "lev" + vo.getLev());	
		jdbcTemplate.update(sql, vo.getCid(), vo.getCpw(), vo.getCname(), vo.getCphone());
		
	}

	public List<UserVO> listUser(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVO getUser(String cid,String cpw) {
		
		UserVO result = null;
		String sql = "select * from customer where cid = ? and cpw = ?";
		Object[] args = {cid,cpw};
		result = jdbcTemplate.queryForObject(sql, args, new UserMapper());
		
		return result;
	}

	public void delUser() {
		// TODO Auto-generated method stub
		
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
