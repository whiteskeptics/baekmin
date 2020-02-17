package com.project.bustaja.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.user.dao.UserDAO;
import com.project.bustaja.user.dao.UserVO;

@Service
public class UserServiceimpl implements UserService{

	@Autowired
	private UserDAO dao;
	
	
	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
		
	}

	@Override
	public List<UserVO> listUser(int page, int limit) {
		return dao.listUser(page, limit);
	}

	@Override
	public UserVO getUser(String cid,String cpw) {
		return dao.getUser(cid, cpw);
	}

	@Override
	public void delUser() {
		
		dao.delUser();
	}

	@Override
	public void updateUser(UserVO vo) {
		
		dao.updateUser();
	}

	@Override
	public int getCount() {
		
		return dao.getCount();
	}
	
}
