package com.project.bustaja.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.time.dao.TimeDAO;
import com.project.bustaja.time.dao.TimeVO;

@Service
public class TimeServiceimpl implements TimeService{
	
	@Autowired
	private TimeDAO dao;

	@Override
	public void insertTime(TimeVO vo) {
		
		dao.insertTime(vo);
		
	}

	@Override
	public List<TimeVO> listTime(int page, int limit) {
		
		return dao.listTime(page, limit);
	}

	@Override
	public TimeVO getTime() {
		TimeVO vo = dao.getTime();
		return vo;
	}

	@Override
	public void delTime(int busNum) {
		dao.delTime(busNum);
		
	}

	@Override
	public void updateTime(TimeVO vo) {
		
		dao.updateTime(vo);
	}

	@Override
	public int getCount() {
		
		return dao.getCount();
	}

}
