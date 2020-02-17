package com.project.bustaja.user.service;

import java.util.List;

import com.project.bustaja.user.dao.UserVO;

public interface UserService {
	void insertUser(UserVO vo); //입력작업
	List<UserVO> listUser(int page, int limit); //전체 조회작업(전체  목록 조회)
	UserVO getUser(String cid,String cpw); //특정 user 조회(결과가 1개 나옴)
	void delUser(); //삭제작업
	void updateUser(UserVO vo);
	int getCount();
}
