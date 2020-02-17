package com.project.bustaja.time.service;

import java.util.List;

import com.project.bustaja.time.dao.TimeVO;

public interface TimeService {
	void insertTime(TimeVO vo); //입력작업
	List<TimeVO> listTime(int page, int limit); //전체 조회작업(전체 배차 목록 조회)
	TimeVO getTime(); //특정 노선 배차 조회(결과가 1개 나옴)
	void delTime(int busNum); //배차 삭제작업
	void updateTime(TimeVO vo);
	int getCount();

}
