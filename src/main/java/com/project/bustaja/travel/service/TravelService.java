package com.project.bustaja.travel.service;

import java.util.List;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.travel.dao.TravelVO;

public interface TravelService {
	void insertTravel(TravelVO vo); //입력작업
	List<TravelVO> listTravel(int page, int limit); //전체 조회작업(전체 운행노선 목록 조회)
	List<TravelVO> getTravel(); //특정 운행노선 조회(결과가 1개 나옴)
	void delTravel(int travelNum); //운행노선 삭제작업
	void updateTravel(TravelVO vo);
	int getCount();

}
