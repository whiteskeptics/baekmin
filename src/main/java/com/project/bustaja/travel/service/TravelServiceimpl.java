package com.project.bustaja.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.travel.dao.TravelDAO;
import com.project.bustaja.travel.dao.TravelVO;

@Service
public class TravelServiceimpl implements TravelService{
	
	@Autowired
	private TravelDAO dao;

	@Override
	public void insertTravel(TravelVO vo) {
		dao.insertTravel(vo);
		
	}

	@Override
	public List<TravelVO> listTravel(int page, int limit) {
		
		return dao.listTravel(page, limit);
	}

	@Override
	public List<TravelVO> getTravel() {
		List<TravelVO> list = dao.getTravel();
		return list;
	}

	@Override
	public void delTravel(int travelNum) {
		dao.delTravel(travelNum);
	}

	@Override
	public void updateTravel(TravelVO vo) {
		dao.updateTravel(vo);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

}
